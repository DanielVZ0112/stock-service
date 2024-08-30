package com.emazon.stockservice.domain.spi;

import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.model.PaginatedResult;

public interface iCategoriaPersistencePort {

    void createCategoria(Categoria categoria);

    PaginatedResult<Categoria> getAllCategorias(int page, int size, String sortDirection);

    Categoria getCategoria(Long id);

    void updateCategoria(Categoria categoria);

    void deleteCategoria(Long id);

}
