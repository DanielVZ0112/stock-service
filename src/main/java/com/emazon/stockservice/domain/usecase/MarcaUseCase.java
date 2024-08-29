package com.emazon.stockservice.domain.usecase;

import com.emazon.stockservice.domain.api.iMarcaServicePort;
import com.emazon.stockservice.domain.model.Marca;
import com.emazon.stockservice.domain.spi.iMarcaPersistencePort;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaDescripcionMaximumCharacterException;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaNombreMaximumCharacterExcepcion;

import java.util.List;

public class MarcaUseCase implements iMarcaServicePort {

    private final iMarcaPersistencePort marcaPersistencePort;

    public MarcaUseCase(iMarcaPersistencePort marcaPersistencePort) {
        this.marcaPersistencePort = marcaPersistencePort;
    }

    @Override
    public Marca createMarca(Marca marca) {
        int maximoNumeroNombreMarca = 50;
        if (marca.getNombre() == null || marca.getNombre().length() > maximoNumeroNombreMarca) {
            throw new CategoriaNombreMaximumCharacterExcepcion("maximo",maximoNumeroNombreMarca);
        }
        int maximoNumeroDescripcionMarca = 120;
        if (marca.getDescripcion() != null && marca.getDescripcion().length() > maximoNumeroDescripcionMarca) {
            throw new CategoriaDescripcionMaximumCharacterException(maximoNumeroDescripcionMarca);
        }
        marcaPersistencePort.createMarca(marca);
        return marca;
    }

    @Override
    public List<Marca> getAllMarca() {
        return marcaPersistencePort.getAllMarca();
    }

    @Override
    public Marca getMarca(Long id) {
        return marcaPersistencePort.getMarca(id);
    }

    @Override
    public void updateMarca(Marca categoria) {
        marcaPersistencePort.updateMarca(categoria);
    }

    @Override
    public void deleteMarca(Long id) {
        marcaPersistencePort.deleteMarca(id);
    }
}
