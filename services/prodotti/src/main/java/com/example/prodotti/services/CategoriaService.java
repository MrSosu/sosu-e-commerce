package com.example.prodotti.services;

import com.example.prodotti.entities.Categoria;
import com.example.prodotti.exceptions.CategoriaNotFoundException;
import com.example.prodotti.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria getCategoriaById(Long id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isEmpty())
            throw new CategoriaNotFoundException("La categoria con id " + id + " non esiste!");
        return optionalCategoria.get();
    }

    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria newCategoria) {
        Categoria oldCategoria = getCategoriaById(id);
        oldCategoria.setNome(newCategoria.getNome());
        oldCategoria.setDescrizione(newCategoria.getDescrizione());
        return categoriaRepository.save(oldCategoria);
    }

    public void deleteCategoriaById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
