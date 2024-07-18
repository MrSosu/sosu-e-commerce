package com.example.ordini.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdineRequest {

    private Long id_carrello;
    private Long id_prodotto;
    private Integer quantita;


}
