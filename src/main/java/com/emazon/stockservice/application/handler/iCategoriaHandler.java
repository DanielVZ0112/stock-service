package com.emazon.stockservice.application.handler;

import com.emazon.stockservice.application.dto.CategoriaDTORequest;
import com.emazon.stockservice.application.dto.CategoriaDTOResponse;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface iCategoriaHandler {

    void createCategoriaInStockService(CategoriaDTORequest categoriaDTORequest);

    Page<CategoriaDTOResponse> getAllCategoriasFromStockService(Pageable pageable);

    CategoriaDTOResponse getCategoriaFromStockService(Long id);

    void updateCategoriaInStockService(CategoriaDTORequest categoriaDTORequest);

    void deleteCategoriaFromStockService(Long id);
}
