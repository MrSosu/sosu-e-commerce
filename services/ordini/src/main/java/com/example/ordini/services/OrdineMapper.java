package com.example.ordini.services;

import com.example.ordini.dto.OrdineResponse;
import com.example.ordini.entities.Ordine;
import org.springframework.stereotype.Service;

@Service
public class OrdineMapper {

    public OrdineResponse responseFromOrdine(Ordine ordine) {
        return OrdineResponse.builder()
                .idProdotto(ordine.getIdProdotto())
                .quantita(ordine.getQuantita())
                .build();
    }

}
