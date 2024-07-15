package com.example.prodotti.services;

import com.example.prodotti.entities.Categoria;
import com.example.prodotti.entities.Prodotto;
import com.example.prodotti.dto.ProdottoRequest;
import com.example.prodotti.dto.ProdottoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdottoMapper {

    @Autowired
    private CategoriaService categoriaService;

    public Prodotto prodottoFromRequest(ProdottoRequest request) {
        return Prodotto.builder()
                .nome(request.getNome())
                .descrizione(request.getDescrizione())
                .prezzo(request.getPrezzo())
                .quantita(request.getQuantita())
                .categoria(request.getIdCategorie()
                        .stream()
                        .map(categoriaService::getCategoriaById)
                        .toList())
                .build();
    }

    public ProdottoResponse responseFromProdotto(Prodotto prodotto) {
        return ProdottoResponse.builder()
                .id(prodotto.getId())
                .nome(prodotto.getNome())
                .descrizione(prodotto.getDescrizione())
                .prezzo(prodotto.getPrezzo())
                .quantita(prodotto.getQuantita())
                .idCategorie(prodotto.getCategoria()
                        .stream()
                        .map(Categoria::getId)
                        .toList())
                .build();
    }

}
