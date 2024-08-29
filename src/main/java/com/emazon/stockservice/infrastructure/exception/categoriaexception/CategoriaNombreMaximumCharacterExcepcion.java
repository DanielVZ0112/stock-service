package com.emazon.stockservice.infrastructure.exception.categoriaexception;

public class CategoriaNombreMaximumCharacterExcepcion extends RuntimeException {
    public CategoriaNombreMaximumCharacterExcepcion(String string, Integer number) {
        super("El nombre de la categoría debe tener un "+ string +" de " + number + " caracteres.");
    }
}
