package com.example.prodotti.entities;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProdottoRequest {

    private String nome;
    private String descrizione;
    private Double prezzo;
    private Integer quantita;
    private List<Long> idCategorie;

}
