package com.emazon.stockservice.domain.api;

import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.model.PaginatedResult;

import java.util.List;

public interface iCategoriaServicePort {

    void createCategoria(Categoria categoria);

    PaginatedResult<Categoria> getAllCategorias(int pageNumber, int pageSize, String string);

    Categoria getCategoria(Long id);

    void updateCategoria(Categoria categoria);

    void deleteCategoria(Long id);

}
