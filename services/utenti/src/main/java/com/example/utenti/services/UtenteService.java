package com.example.utenti.services;

import com.example.utenti.dto.IndirizzoRequest;
import com.example.utenti.dto.UtenteRequest;
import com.example.utenti.dto.UtenteResponse;
import com.example.utenti.entities.Indirizzo;
import com.example.utenti.entities.Utente;
import com.example.utenti.exceptions.UtenteNotFoundException;
import com.example.utenti.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private UtenteMapper utenteMapper;
    @Autowired
    private IndirizzoService indirizzoService;

    public Utente getUtente(Long id) {
        Optional<Utente> optionalUtente = utenteRepository.findById(id);
        if (optionalUtente.isEmpty())
            throw new UtenteNotFoundException("Utente con id " + id + " non esiste!");
        return optionalUtente.get();
    }

    public UtenteResponse getUtenteById(Long id) {
        Optional<Utente> optionalUtente = utenteRepository.findById(id);
        if (optionalUtente.isEmpty())
            throw new UtenteNotFoundException("Utente con id " + id + " non esiste!");
        Utente utente = optionalUtente.get();
        return utenteMapper.responseFromUtente(utente);
    }


    public List<UtenteResponse> getAll() {
        return utenteRepository.findAll().stream().map(utenteMapper::responseFromUtente).toList();
    }


    public UtenteResponse createUtente(UtenteRequest request) {
        Utente utente = utenteRepository.save(utenteMapper.utenteFromRequest(request));
        return utenteMapper.responseFromUtente(utente);
    }

    public UtenteResponse updateUtente(Long id, UtenteRequest newUtente) {
        Utente utente = getUtente(id);
        utente.setNome(newUtente.getNome());
        utente.setCognome(newUtente.getCognome());
        utente.setEmail(newUtente.getEmail());
        utente.setDataNascita(newUtente.getDataNascita());
        utenteRepository.save(utente);
        return utenteMapper.responseFromUtente(utente);
    }

    public void deleteUtenteById(Long id) {
        getUtenteById(id);
        utenteRepository.deleteById(id);
    }

    public Indirizzo addIndirizzo(IndirizzoRequest request) {
        Indirizzo indirizzo = Indirizzo.builder()
                .via(request.getVia())
                .civico(request.getCivico())
                .cap(request.getCap())
                .comune(request.getComune())
                .build();
        indirizzoService.createIndirizzo(indirizzo);
        Utente utente = getUtente(request.getIdUtente());
        utente.getIndirizzi().add(indirizzo);
        utenteRepository.save(utente);
        return indirizzo;
    }


    public void deleteIndirizzo(Long idIndirizzo) {
        indirizzoService.deleteIndirizzoById(idIndirizzo);
    }

    public List<Indirizzo> getIndirizziUtente(Long idUtente) {
        Utente utente = getUtente(idUtente);
        return utente.getIndirizzi();
    }
}
