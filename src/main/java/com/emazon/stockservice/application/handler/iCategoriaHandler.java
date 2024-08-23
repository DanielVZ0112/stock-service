package com.emazon.stockservice.application.handler;

import com.emazon.stockservice.application.dto.CategoriaDTO;

import java.util.List;

public interface iCategoriaHandler {

    void createCategoriaInStockService(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> getAllCategoriasFromStockService();

    CategoriaDTO getCategoriaFromStockService(Long id);

    void updateCategoriaInStckService(CategoriaDTO categoria);

    void deleteCategoriaFromStockService(Long id);
}
