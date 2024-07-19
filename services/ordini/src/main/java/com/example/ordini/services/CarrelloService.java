package com.example.ordini.services;

import com.example.ordini.dto.CarrelloRequest;
import com.example.ordini.dto.CarrelloResponse;
import com.example.ordini.entities.Carrello;
import com.example.ordini.entities.Ordine;
import com.example.ordini.exception.BusinessException;
import com.example.ordini.exception.CarrelloNotFoundException;
import com.example.ordini.kafka.OrderConfirmation;
import com.example.ordini.kafka.OrderProducer;
import com.example.ordini.prodotto.ProdottoClient;
import com.example.ordini.prodotto.ProdottoPurchaseRequest;
import com.example.ordini.repositories.CarrelloRepository;
import com.example.ordini.utente.UtenteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarrelloService {

    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private CarrelloMapper carrelloMapper;
    @Autowired
    private OrdineService ordineService;
    @Autowired
    private UtenteClient utenteClient;
    @Autowired
    private ProdottoClient prodottoClient;
    @Autowired
    private OrderProducer orderProducer;

    public CarrelloResponse getCarrelloById(Long id) {
        Optional<Carrello> optionalCarrello = carrelloRepository.findById(id);
        if (optionalCarrello.isEmpty())
            throw new CarrelloNotFoundException("il carrello con id " + id + " non è presente!");
        return carrelloMapper.responseFromCarrello(optionalCarrello.get());
    }

    public Carrello getCarrello(Long id) {
        Optional<Carrello> optionalCarrello = carrelloRepository.findById(id);
        if (optionalCarrello.isEmpty())
            throw new CarrelloNotFoundException("il carrello con id " + id + " non è presente!");
        return optionalCarrello.get();    }

    public CarrelloResponse createCarrello(CarrelloRequest request) {
        // check se esiste l'utente
        var utente = utenteClient.findUtenteById(request.getIdUtente());
        if (utente.isEmpty())
            throw new BusinessException("L'utente con id " + request.getIdUtente() + " non esiste! Ordine impossibile da effettuare");
        // acquisto dei prodotti
        prodottoClient.purchaseProdotti(request.getProdottoPurchaseRequests());
        // salvo il carrello nel database
        Carrello carrello = carrelloRepository.save(carrelloMapper.carrelloFromRequest(request));
        // salvo i singoli ordini
        List<Ordine> ordineList = new ArrayList<>();
        for (ProdottoPurchaseRequest pRequest : request.getProdottoPurchaseRequests()) {
            Ordine ordine = ordineService.saveOrdine(Ordine.builder()
                    .carrello(carrello)
                    .idProdotto(pRequest.getIdProdotto())
                    .quantita(pRequest.getQuantita())
                    .build());
            ordineList.add(ordine);
        }
        carrello.setOrdineList(ordineList);
        carrelloRepository.save(carrello);
        // processare il servizio di pagamento

        // inviare l'order confirmation ---> tramite KAFKAAAAAAAAAAA
        orderProducer.sendConfermaOrdine(
                OrderConfirmation.builder()
                        .idOrdine(carrello.getId())
                        .idUtente(carrello.getIdUtente())
                        .totalAmount(carrello.getTotalAmount())
                        .prodotti(request.getProdottoPurchaseRequests())
                        .build());
        return carrelloMapper.responseFromCarrello(carrello);
    }


}
