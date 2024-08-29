package com.emazon.stockservice.domain.categoriausecase;

import com.emazon.stockservice.domain.api.iCategoriaServicePort;
import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaDescripcionMaximumCharacterException;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaNombreMaximumCharacterExcepcion;

import java.util.List;

public class CategoriaUseCase implements iCategoriaServicePort {

    private final iCategoriaPersistencePort categoriaPersistencePort;

    public CategoriaUseCase(iCategoriaPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        int maximoNumeroNombreCategorias = 50;
        if (categoria.getNombre() == null || categoria.getNombre().length() > maximoNumeroNombreCategorias) {
            throw new CategoriaNombreMaximumCharacterExcepcion(maximoNumeroNombreCategorias);
        }
        int maximoNumeroDescripcionCategorias = 90;
        if (categoria.getDescripcion() != null && categoria.getDescripcion().length() > maximoNumeroDescripcionCategorias) {
            throw new CategoriaDescripcionMaximumCharacterException(maximoNumeroDescripcionCategorias);
        }
        categoriaPersistencePort.createCategoria(categoria);
        return categoria;
    }


    @Override
    public List<Categoria> getAllCategorias(int pageNumber, int pageSize, String sortDirection) {
        if (pageNumber < 0) {
            pageNumber = 0;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }
        if (!sortDirection.equalsIgnoreCase("asc") && !sortDirection.equalsIgnoreCase("desc")) {
            sortDirection = "asc";
        }

        return categoriaPersistencePort.getAllCategorias(pageNumber, pageSize, sortDirection);
    }

    @Override
    public Categoria getCategoria(Long id) {
        return categoriaPersistencePort.getCategoria(id);
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        categoriaPersistencePort.updateCategoria(categoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaPersistencePort.deleteCategoria(id);
    }
}
