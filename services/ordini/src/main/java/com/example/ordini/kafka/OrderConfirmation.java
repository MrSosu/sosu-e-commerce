package com.example.ordini.kafka;

import com.example.ordini.entities.Ordine;
import com.example.ordini.prodotti.PurchaseResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderConfirmation {

    private Long idCarrello;
    private Long idUtente;
    private Double totalAmount;
    private List<Ordine> purchasedProducts;

}
