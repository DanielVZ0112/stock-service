package com.emazon.stockservice.infrastructure.exception.marcaexception;

public class MarcaDuplicateException extends RuntimeException{
    public MarcaDuplicateException(String message) {
        super("La marca " + message + " ya existe.");
    }
}

