package com.emazon.stockservice.application.handler;

import com.emazon.stockservice.application.dto.MarcaDTORequest;
import com.emazon.stockservice.application.dto.MarcaDTOResponse;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface iMarcaHandler {
    void createMarcaInStockService(MarcaDTORequest marcaDTORequest);

    Page<MarcaDTOResponse> getAllMarcaFromStockService(Pageable pageable);

    MarcaDTOResponse getMarcaFromStockService(Long id);

    void updateMarcaInStockService(MarcaDTORequest marcaDTORequest);

    void deleteMarcaFromStockService(Long id);
}
