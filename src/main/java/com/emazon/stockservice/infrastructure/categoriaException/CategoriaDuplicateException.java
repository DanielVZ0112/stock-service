package com.emazon.stockservice.infrastructure.categoriaException;

public class CategoriaDuplicateException extends RuntimeException {
    public CategoriaDuplicateException(String message) {
        super("La categoria " + message + " ya existe.");
    }
}