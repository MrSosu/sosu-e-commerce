package com.example.ordini.utente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "utenti-service", url = "${application.config.utenti-url}")
public interface UtenteClient {

    @GetMapping("/get/{id}")
    Optional<UtenteResponse> findUtenteById(@PathVariable Long id);

}
