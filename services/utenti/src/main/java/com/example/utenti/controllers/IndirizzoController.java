package com.example.utenti.controllers;

import com.example.utenti.entities.Indirizzo;
import com.example.utenti.handler.GenericResponse;
import com.example.utenti.services.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utenti/address")
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Indirizzo> getCategoriaById(@PathVariable Long id) {
        return new ResponseEntity<>(indirizzoService.getIndirizzoById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Indirizzo>> getAll() {
        return new ResponseEntity<>(indirizzoService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Indirizzo> createCategoria(@RequestBody Indirizzo indirizzo) {
        return new ResponseEntity<>(indirizzoService.createIndirizzo(indirizzo), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Indirizzo> updateCategoria(@PathVariable Long id, @RequestBody Indirizzo newIndirizzo) {
        return new ResponseEntity<>(indirizzoService.updateIndirizzo(id, newIndirizzo), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteCategoriaById(@PathVariable Long id) {
        indirizzoService.deleteIndirizzoById(id);
        return new ResponseEntity<>(new GenericResponse("indirizzo con id " + id + " eliminato con successo!"), HttpStatus.OK);
    }

}
