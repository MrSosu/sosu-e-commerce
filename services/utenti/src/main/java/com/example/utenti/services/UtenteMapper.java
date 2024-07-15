package com.example.utenti.services;

import com.example.utenti.dto.UtenteRequest;
import com.example.utenti.dto.UtenteResponse;
import com.example.utenti.entities.Indirizzo;
import com.example.utenti.entities.Utente;
import org.springframework.stereotype.Service;

@Service
public class UtenteMapper {

    public Utente utenteFromRequest(UtenteRequest request) {
        return Utente.builder()
                .nome(request.getNome())
                .cognome(request.getCognome())
                .dataNascita(request.getDataNascita())
                .email(request.getEmail())
                .build();
    }

    public UtenteResponse responseFromUtente(Utente utente) {
        UtenteResponse utenteResponse = UtenteResponse.builder()
                .id(utente.getId())
                .nome(utente.getNome())
                .cognome(utente.getCognome())
                .email(utente.getEmail())
                .dataNascita(utente.getDataNascita())
                .build();
        if (!utente.getIndirizzi().isEmpty())
            utenteResponse.setIdIndirizzi(utente.getIndirizzi().stream().map(Indirizzo::getId).toList());
        return utenteResponse;
    }

}
