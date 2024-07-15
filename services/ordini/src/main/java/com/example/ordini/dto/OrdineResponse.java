package com.example.ordini.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdineResponse {

    private Long idProdotto;
    private Integer quantita;

}
