package com.example.ordini.prodotto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdottoPurchaseRequest {

    private Long idProdotto;
    private Integer quantita;

}
