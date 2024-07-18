package com.example.ordini.prodotti;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseRequest {

    private Long idProdotto;
    private Integer quantita;

}
