package com.example.ordini.services;

import com.example.ordini.dto.CarrelloRequest;
import com.example.ordini.dto.CarrelloResponse;
import com.example.ordini.dto.OrdineRequest;
import com.example.ordini.entities.Carrello;
import com.example.ordini.entities.Ordine;
import com.example.ordini.exception.BusinessException;
import com.example.ordini.exception.CarrelloNotFoundException;
import com.example.ordini.kafka.OrderConfirmation;
import com.example.ordini.kafka.OrderProducer;
import com.example.ordini.prodotti.ProdottoClient;
import com.example.ordini.prodotti.PurchaseRequest;
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
    private UtenteClient utenteClient;
    @Autowired
    private ProdottoClient prodottoClient;
    @Autowired
    private OrdineService ordineService;
    @Autowired
    private OrderProducer orderProducer;

    public CarrelloResponse createCarrello(CarrelloRequest request) {
        // check dell'utente
        var utente = utenteClient.findUtenteById(request.getIdUtente());
        if (utente.isEmpty())
            throw new BusinessException("L'utente con id " + request.getIdUtente() + " non esiste! Carrello non disponibile.");
        // acquisto prodotti
        prodottoClient.purchaseProdotti(request.getPurchaseRequests());
        // persist del carrello
        Carrello carrello = carrelloRepository.save(carrelloMapper.carrelloFromRequest(request));
        // persist dei singoli ordini
        List<Ordine> ordineList = new ArrayList<>();
        for (PurchaseRequest pRequest : request.getPurchaseRequests()) {
            Ordine ordine = ordineService.saveOrdine(new OrdineRequest(carrello.getId(), pRequest.getIdProdotto(), pRequest.getQuantita()));
            ordineList.add(ordine);
        }
        carrello.setOrdineList(ordineList);
        // iniziare il processo di pagamento

        // inviare l'order confirmation ---> notifica con Kafka
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        carrello.getId(),
                        request.getIdUtente(),
                        request.getTotalAmount(),
                        carrello.getOrdineList()
                )
        );
        return null;
    }

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




}
