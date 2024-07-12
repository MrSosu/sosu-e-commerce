package com.example.prodotti.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProdottoPurchaseRequest {

    private Long id_prodotto;
    private Integer quantita;

}
