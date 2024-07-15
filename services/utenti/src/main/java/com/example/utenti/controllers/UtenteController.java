package com.example.utenti.controllers;

import com.example.utenti.dto.IndirizzoRequest;
import com.example.utenti.dto.UtenteRequest;
import com.example.utenti.dto.UtenteResponse;
import com.example.utenti.entities.Indirizzo;
import com.example.utenti.entities.Utente;
import com.example.utenti.handler.GenericResponse;
import com.example.utenti.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UtenteResponse> getUtenteById(@PathVariable Long id) {
        return new ResponseEntity<>(utenteService.getUtenteById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UtenteResponse>> getAll() {
        return new ResponseEntity<>(utenteService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UtenteResponse> createUtente(@RequestBody UtenteRequest request) {
        return new ResponseEntity<>(utenteService.createUtente(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UtenteResponse> updateUtente(@PathVariable Long id, @RequestBody UtenteRequest newUtente) {
        return new ResponseEntity<>(utenteService.updateUtente(id, newUtente), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteUtenteById(@PathVariable Long id) {
        utenteService.deleteUtenteById(id);
        return new ResponseEntity<>(new GenericResponse("utente con id " + id + " eliminato con successo!"), HttpStatus.OK);
    }

    @GetMapping("/get_indirizzi/{id}")
    public ResponseEntity<List<Indirizzo>> getIndirizziByUtenteId(@PathVariable Long id_utente) {
        return new ResponseEntity<>(utenteService.getIndirizziUtente(id_utente), HttpStatus.OK);
    }

    @PostMapping("/add_indirizzo")
    public ResponseEntity<Indirizzo> addIndirizzo(@RequestBody IndirizzoRequest request) {
        return new ResponseEntity<>(utenteService.addIndirizzo(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_indirizzo")
    public ResponseEntity<GenericResponse> deleteIndirizzoById(Long id_indirizzo) {
        utenteService.deleteIndirizzo(id_indirizzo);
        return new ResponseEntity<>(new GenericResponse("indirizzo con id " + id_indirizzo + " eliminato con successo!"), HttpStatus.OK);
    }

}
