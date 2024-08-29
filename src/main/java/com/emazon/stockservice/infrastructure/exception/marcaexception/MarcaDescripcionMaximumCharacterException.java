package com.emazon.stockservice.infrastructure.exception.marcaexception;



public class MarcaDescripcionMaximumCharacterException extends RuntimeException {
    public MarcaDescripcionMaximumCharacterException(Integer number) {
        super("La descripción de la marca debe tener un máximo de" + number + "caracteres.");
    }
}
