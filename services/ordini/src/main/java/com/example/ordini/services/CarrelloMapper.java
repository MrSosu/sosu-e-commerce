package com.example.ordini.services;

import com.example.ordini.dto.CarrelloRequest;
import com.example.ordini.dto.CarrelloResponse;
import com.example.ordini.entities.Carrello;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CarrelloMapper {

    public CarrelloResponse responseFromCarrello(Carrello carrello) {
        return CarrelloResponse.builder()
                .id(carrello.getId())
                .idUtente(carrello.getIdUtente())
                .totalAmount(carrello.getTotalAmount())
                .build();
    }

    public Carrello carrelloFromRequest(CarrelloRequest request) {
        return Carrello.builder()
                .idUtente(request.getIdUtente())
                .totalAmount(request.getTotalAmount())
                .createdDate(LocalDateTime.now())
                .build();
    }
}
