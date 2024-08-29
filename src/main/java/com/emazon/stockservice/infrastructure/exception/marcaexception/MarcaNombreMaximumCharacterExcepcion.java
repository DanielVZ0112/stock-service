package com.emazon.stockservice.infrastructure.exception.marcaexception;

public class MarcaNombreMaximumCharacterExcepcion extends RuntimeException {
    public MarcaNombreMaximumCharacterExcepcion(String string, Integer number) {
    super("El nombre de la marca debe tener un "+ string +" de " + number + " caracteres.");
}

}
