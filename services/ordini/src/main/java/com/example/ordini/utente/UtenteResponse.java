package com.example.ordini.utente;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtenteResponse {

    private Long id;
    private String nome;
    private String cognome;
    private String email;

}
