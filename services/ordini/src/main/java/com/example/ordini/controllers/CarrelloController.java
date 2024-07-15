package com.example.ordini.controllers;

import com.example.ordini.dto.CarrelloRequest;
import com.example.ordini.dto.CarrelloResponse;
import com.example.ordini.services.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carrelli")
public class CarrelloController {

    @Autowired
    private CarrelloService carrelloService;

    @GetMapping("/get/{id}")
    public ResponseEntity<CarrelloResponse> getCarrelloById(@PathVariable Long id) {
        return new ResponseEntity<>(carrelloService.getCarrelloById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CarrelloResponse> createCarrello(@RequestBody CarrelloRequest request) {
        return new ResponseEntity<>(carrelloService.createCarrello(request), HttpStatus.CREATED);
    }

}
