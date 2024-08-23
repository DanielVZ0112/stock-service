package com.emazon.stockservice.infrastructure.repository;

import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements iCategoriaPersistencePort {
    @Override
    public void createCategoria(Categoria categoria) {

    }

    @Override
    public List<Categoria> getAllCategorias() {
        return List.of();
    }

    @Override
    public Categoria getCategoria(Long id) {
        return null;
    }

    @Override
    public void updateCategoria(Categoria categoria) {

    }

    @Override
    public void deleteCategoria(Long id) {

    }

    // Implementación de los métodos aquí
}
