package com.emazon.stockservice.infrastructure.exception;

import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaDescripcionMaximumCharacterException;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaDuplicateException;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaNombreMaximumCharacterExcepcion;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaNotFoundException;
import com.emazon.stockservice.infrastructure.exception.marcaexception.MarcaDescripcionMaximumCharacterException;
import com.emazon.stockservice.infrastructure.exception.marcaexception.MarcaDuplicateException;
import com.emazon.stockservice.infrastructure.exception.marcaexception.MarcaNombreMaximumCharacterExcepcion;
import com.emazon.stockservice.infrastructure.exception.marcaexception.MarcaNotFoundException;
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
    @ExceptionHandler(MarcaDescripcionMaximumCharacterException.class)
    public ResponseEntity<String> handleCategoriaDuplicadaException(MarcaDescripcionMaximumCharacterException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MarcaDuplicateException.class)
    public ResponseEntity<String> handleCategoriaDuplicadaException(MarcaDuplicateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MarcaNombreMaximumCharacterExcepcion.class)
    public ResponseEntity<String> handleCategoriaDuplicadaException(MarcaNombreMaximumCharacterExcepcion ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MarcaNotFoundException.class)
    public ResponseEntity<String> handleCategoriaDuplicadaException(MarcaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
