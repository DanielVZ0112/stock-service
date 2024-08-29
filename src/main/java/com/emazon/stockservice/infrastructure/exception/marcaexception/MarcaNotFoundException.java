package com.emazon.stockservice.infrastructure.exception.marcaexception;

public class MarcaNotFoundException extends RuntimeException{
    public MarcaNotFoundException() {
        super("Marca no encontrada");}
}
