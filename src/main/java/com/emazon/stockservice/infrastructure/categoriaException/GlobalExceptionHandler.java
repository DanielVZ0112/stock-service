package com.emazon.stockservice.infrastructure.categoriaException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoriaDuplicateException.class)
    public ResponseEntity<String> handleCategoriaDuplicadaException(CategoriaDuplicateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<String> handleCategoriaDuplicadaException(CategoriaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CategoriaNombreMaximumCharacterExcepcion.class)
    public ResponseEntity<String> handleCategoriaDuplicadaException(CategoriaNombreMaximumCharacterExcepcion ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CategoriaDescripcionMaximumCharacterException.class)
    public ResponseEntity<String> handleCategoriaDuplicadaException(CategoriaDescripcionMaximumCharacterException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
