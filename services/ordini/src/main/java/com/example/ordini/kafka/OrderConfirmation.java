package com.example.ordini.kafka;

import com.example.ordini.prodotto.ProdottoPurchaseRequest;
import com.example.ordini.prodotto.ProdottoPurchaseResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderConfirmation {

    private Long idOrdine;
    private Double totalAmount;
    private Long idUtente;
    private List<ProdottoPurchaseRequest> prodotti;

}
