package com.example.prodotti.dto;

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
