package com.emazon.stockservice.infrastructure.exception.categoriaexception;

public class CategoriaDuplicateException extends RuntimeException {
    public CategoriaDuplicateException(String message) {
        super("La categoria " + message + " ya existe.");
    }
}