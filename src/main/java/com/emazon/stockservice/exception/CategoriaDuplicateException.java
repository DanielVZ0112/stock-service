package com.emazon.stockservice.exception;

public class CategoriaDuplicateException extends RuntimeException {
    public CategoriaDuplicateException(String message) {
        super(message);
    }
}