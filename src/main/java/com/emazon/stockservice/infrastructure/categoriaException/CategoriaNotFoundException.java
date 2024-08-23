package com.emazon.stockservice.infrastructure.categoriaException;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException() {
        super("Categoria no encontrada");}
}
