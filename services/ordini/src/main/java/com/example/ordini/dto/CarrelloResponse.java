package com.example.ordini.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarrelloResponse {

    private Long id;
    private Long idUtente;
    private Double totalAmount;

}
