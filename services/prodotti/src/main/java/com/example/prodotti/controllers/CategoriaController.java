package com.example.prodotti.controllers;

import com.example.prodotti.entities.Categoria;
import com.example.prodotti.handler.GenericResponse;
import com.example.prodotti.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorie")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        return new ResponseEntity<>(categoriaService.getCategoriaById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Categoria>> getAll() {
        return new ResponseEntity<>(categoriaService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(categoriaService.createCategoria(categoria), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria newCategoria) {
        return new ResponseEntity<>(categoriaService.updateCategoria(id, newCategoria), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteCategoriaById(@PathVariable Long id) {
        categoriaService.deleteCategoriaById(id);
        return new ResponseEntity<>(new GenericResponse("categoria con id " + id + " eliminata con successo!"), HttpStatus.OK);
    }

}
