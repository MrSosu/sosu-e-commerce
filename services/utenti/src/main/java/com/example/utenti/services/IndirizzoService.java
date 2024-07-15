package com.example.utenti.services;

import com.example.utenti.entities.Indirizzo;
import com.example.utenti.exceptions.IndirizzoNotFoundException;
import com.example.utenti.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndirizzoService {

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    public Indirizzo getIndirizzoById(Long id) {

        Optional<Indirizzo> optionalIndirizzo = indirizzoRepository.findById(id);
        if (optionalIndirizzo.isEmpty())
            throw new IndirizzoNotFoundException("indirizzo con id " + id + " non esiste!");
        return optionalIndirizzo.get();

    }

    public List<Indirizzo> getAll() {
        return indirizzoRepository.findAll();
    }

    public Indirizzo createIndirizzo(Indirizzo indirizzo) {
        return indirizzoRepository.save(indirizzo);
    }

    public Indirizzo updateIndirizzo(Long id, Indirizzo new_indirizzo) {
        Indirizzo oldIndirizzo = getIndirizzoById(id);
        oldIndirizzo.setVia(new_indirizzo.getVia());
        oldIndirizzo.setCivico(new_indirizzo.getCivico());
        oldIndirizzo.setCap(new_indirizzo.getCap());
        oldIndirizzo.setComune(new_indirizzo.getComune());
        indirizzoRepository.save(oldIndirizzo);
        return new_indirizzo;
    }

    public void deleteIndirizzoById(Long id) {
        getIndirizzoById(id);
        indirizzoRepository.deleteById(id);
    }

}
