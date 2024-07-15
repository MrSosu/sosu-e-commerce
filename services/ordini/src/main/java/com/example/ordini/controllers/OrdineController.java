package com.example.ordini.controllers;

import com.example.ordini.dto.OrdineResponse;
import com.example.ordini.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ordine")
public class OrdineController {

    @Autowired
    private OrdineService ordineService;

    @GetMapping("/get/{id_carrello}")
    public ResponseEntity<List<OrdineResponse>> getOrdiniByCarrelloId(@PathVariable Long id_carrello) {
        return new ResponseEntity<>(ordineService.getOrdiniByCarrelloId(id_carrello), HttpStatus.OK);
    }

}
