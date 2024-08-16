package com.emazon.stockservice.adapter.controller;

import com.emazon.stockservice.exception.CategoriaDuplicadaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoriaDuplicadaException.class)
    public ResponseEntity<String> handleCategoriaDuplicadaException(CategoriaDuplicadaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
