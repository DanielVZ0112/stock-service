package com.emazon.stockservice.infrastructure.categoriaException;

public class CategoriaNombreMaximumCharacterExcepcion extends RuntimeException {
    public CategoriaNombreMaximumCharacterExcepcion(Integer number) {
        super("El nombre de la categoría debe tener un máximo de " + number + " caracteres.");
    }
}
