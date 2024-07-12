package com.example.prodotti.controllers;

import com.example.prodotti.entities.ProdottoPurchaseRequest;
import com.example.prodotti.entities.ProdottoPurchaseResponse;
import com.example.prodotti.entities.ProdottoRequest;
import com.example.prodotti.entities.ProdottoResponse;
import com.example.prodotti.handler.GenericResponse;
import com.example.prodotti.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prodotti")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ProdottoResponse> getProdottoById(@PathVariable Long id) {
        return new ResponseEntity<>(prodottoService.getProdottoById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProdottoResponse>> getAll() {
        return new ResponseEntity<>(prodottoService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProdottoResponse> createProdotto(@RequestBody ProdottoRequest request) {
        return new ResponseEntity<>(prodottoService.createProdotto(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProdottoResponse> updateProdotto(@PathVariable Long id, @RequestBody ProdottoRequest request) {
        return new ResponseEntity<>(prodottoService.updateProdotto(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteProdottoById(@PathVariable Long id) {
        prodottoService.deleteProdottoById(id);
        return new ResponseEntity<>(new GenericResponse("Prodotto con id " + id + " eliminato correttamente"), HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProdottoPurchaseResponse>> purchaseProdotti
            (@RequestBody List<ProdottoPurchaseRequest> requestList) {
        return new ResponseEntity<>(prodottoService.purchaseProducts(requestList), HttpStatus.OK);
    }


}
