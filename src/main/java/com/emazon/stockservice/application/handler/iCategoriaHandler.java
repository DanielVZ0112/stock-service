package com.emazon.stockservice.application.handler;

import com.emazon.stockservice.application.dto.CategoriaDTORequest;
import com.emazon.stockservice.application.dto.CategoriaDTOResponse;

import java.util.List;

public interface iCategoriaHandler {

    void createCategoriaInStockService(CategoriaDTORequest categoriaDTORequest);

    List<CategoriaDTOResponse> getAllCategoriasFromStockService();

    CategoriaDTOResponse getCategoriaFromStockService(Long id);

    void updateCategoriaInStckService(CategoriaDTORequest categoriaDTORequest);

    void deleteCategoriaFromStockService(Long id);
}
