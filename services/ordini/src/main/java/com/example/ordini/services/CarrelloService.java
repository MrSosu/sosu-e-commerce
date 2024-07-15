package com.example.ordini.services;

import com.example.ordini.dto.CarrelloRequest;
import com.example.ordini.dto.CarrelloResponse;
import com.example.ordini.entities.Carrello;
import com.example.ordini.exception.CarrelloNotFoundException;
import com.example.ordini.repositories.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarrelloService {

    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private CarrelloMapper carrelloMapper;

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
        Carrello carrello = Carrello.builder()
                .idUtente(request.getIdUtente())
                .totalAmount(0.0)
                .ordineList(new ArrayList<>())
                .build();
        carrelloRepository.save(carrello);
        return carrelloMapper.responseFromCarrello(carrello);
    }


}
