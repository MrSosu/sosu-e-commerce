package com.example.ordini.prodotto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdottoPurchaseResponse {

    private Long idProdotto;
    private Integer quantita;
    private String nome;

}
