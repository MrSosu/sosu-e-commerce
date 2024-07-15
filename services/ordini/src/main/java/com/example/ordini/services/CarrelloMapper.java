package com.example.ordini.services;

import com.example.ordini.dto.CarrelloResponse;
import com.example.ordini.entities.Carrello;
import org.springframework.stereotype.Service;

@Service
public class CarrelloMapper {

    public CarrelloResponse responseFromCarrello(Carrello carrello) {
        return CarrelloResponse.builder()
                .id(carrello.getId())
                .idUtente(carrello.getIdUtente())
                .totalAmount(carrello.getTotalAmount())
                .build();
    }

}
