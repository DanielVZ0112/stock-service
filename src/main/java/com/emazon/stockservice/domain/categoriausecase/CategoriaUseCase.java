package com.emazon.stockservice.domain.useCase;

import com.emazon.stockservice.domain.api.iCategoriaServicePort;
import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;

import java.util.List;

public class CategoriaUseCase implements iCategoriaServicePort {

    private final iCategoriaPersistencePort categoriaPersistencePort;

    public CategoriaUseCase(iCategoriaPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        categoriaPersistencePort.createCategoria(categoria);
        return categoria;
    }


    @Override
    public List<Categoria> getAllCategorias(int pageNumber, int pageSize, String string) {
        return categoriaPersistencePort.getAllCategorias(int pageNumber, int pageSize, String string);
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