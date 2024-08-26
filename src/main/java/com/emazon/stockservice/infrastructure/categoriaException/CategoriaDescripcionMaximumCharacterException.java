package com.emazon.stockservice.infrastructure.categoriaException;

public class CategoriaDescripcionMaximumCharacterException extends RuntimeException {
    public CategoriaDescripcionMaximumCharacterException(Integer number) {
        super("La descripción de la categoría debe tener un máximo de" + number + "caracteres.");
    }
}
