package com.example.prodotti.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProdottoPurchaseResponse {

    private Long id_prodotto;
    private String nome;
    private Integer quantita;

}
