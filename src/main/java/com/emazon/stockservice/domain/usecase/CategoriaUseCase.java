package com.emazon.stockservice.domain.usecase;

import com.emazon.stockservice.domain.api.iCategoriaServicePort;
import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.model.PaginatedResult;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaDescripcionMaximumCharacterException;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaNombreMaximumCharacterExcepcion;


public class CategoriaUseCase implements iCategoriaServicePort {

    private final iCategoriaPersistencePort categoriaPersistencePort;

    public CategoriaUseCase(iCategoriaPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }

    @Override
    public void createCategoria(Categoria categoria) {
        int maximoNumeroNombreCategorias = 50;
        if (categoria.getNombre() == null || categoria.getNombre().length() > maximoNumeroNombreCategorias) {
            throw new CategoriaNombreMaximumCharacterExcepcion("maximo",maximoNumeroNombreCategorias);
        }
        int maximoNumeroDescripcionCategorias = 90;
        if (categoria.getDescripcion() != null && categoria.getDescripcion().length() > maximoNumeroDescripcionCategorias) {
            throw new CategoriaDescripcionMaximumCharacterException(maximoNumeroDescripcionCategorias);
        }
        categoriaPersistencePort.createCategoria(categoria);
    }


    @Override
    public PaginatedResult<Categoria> getAllCategorias(int pageNumber, int pageSize, String sortDirection) {
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
