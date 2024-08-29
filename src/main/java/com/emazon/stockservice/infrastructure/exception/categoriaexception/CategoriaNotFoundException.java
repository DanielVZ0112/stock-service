package com.emazon.stockservice.infrastructure.exception.categoriaexception;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException() {
        super("Categoria no encontrada");}
}
