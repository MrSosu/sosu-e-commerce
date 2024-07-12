package com.example.prodotti.handler;

import com.example.prodotti.exceptions.CategoriaNotFoundException;
import com.example.prodotti.exceptions.InputErratoException;
import com.example.prodotti.exceptions.ProdottoNotFoundException;
import com.example.prodotti.exceptions.ProdottoPurchaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdottoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(ProdottoNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .exception(ProdottoNotFoundException.class.getSimpleName())
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler(InputErratoException.class)
    public ResponseEntity<ErrorResponse> handle(InputErratoException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .exception(InputErratoException.class.getSimpleName())
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler(ProdottoPurchaseException.class)
    public ResponseEntity<ErrorResponse> handle(ProdottoPurchaseException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .exception(ProdottoPurchaseException.class.getSimpleName())
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(CategoriaNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .exception(CategoriaNotFoundException.class.getSimpleName())
                        .message(exception.getMessage())
                        .build());
    }

}
