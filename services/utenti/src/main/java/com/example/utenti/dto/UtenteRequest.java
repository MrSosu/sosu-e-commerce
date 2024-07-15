package com.example.utenti.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtenteRequest {

    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String email;

}
