package com.example.prodotti.exceptions;

public class ProdottoNotFoundException extends RuntimeException {

    public ProdottoNotFoundException(String message) {
        super(message);
    }

}
