package com.example.prodotti.handler;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {

    private String exception;
    private String message;

}
