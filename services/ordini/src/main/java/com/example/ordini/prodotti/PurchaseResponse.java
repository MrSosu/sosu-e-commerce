package com.example.ordini.prodotti;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseResponse {

    private Long idProdotto;
    private String nome;
    private String descrizione;
    private Double prezzo;
    private Integer quantita;

}
