package com.example.utenti.handler;

import com.example.utenti.exceptions.IndirizzoNotFoundException;
import com.example.utenti.exceptions.UtenteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IndirizzoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(IndirizzoNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .exception(IndirizzoNotFoundException.class.getSimpleName())
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler(UtenteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(UtenteNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .exception(UtenteNotFoundException.class.getSimpleName())
                        .message(exception.getMessage())
                        .build());
    }

}
