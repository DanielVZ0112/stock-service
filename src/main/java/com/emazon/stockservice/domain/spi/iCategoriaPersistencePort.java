package com.emazon.stockservice.domain.spi;

import com.emazon.stockservice.domain.model.Categoria;

import java.util.List;

public interface iCategoriaPersistencePort {
    void createCategoria(Categoria categoria);

    List<Categoria> getAllCategorias();

    Categoria getCategoria(Long id);

    void updateCategoria(Categoria categoria);

    void deleteCategoria(Long id);

}
