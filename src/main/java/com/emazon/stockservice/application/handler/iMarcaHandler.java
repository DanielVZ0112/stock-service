package com.emazon.stockservice.application.handler;

import com.emazon.stockservice.application.dto.MarcaDTORequest;
import com.emazon.stockservice.application.dto.MarcaDTOResponse;

import java.util.List;

public interface iMarcaHandler {
    void createMarcaInStockService(MarcaDTORequest marcaDTORequest);

    List<MarcaDTOResponse> getAllMarcaFromStockService();

    MarcaDTOResponse getMarcaFromStockService(Long id);

    void updateMarcaInStockService(MarcaDTORequest marcaDTORequest);

    void deleteMarcaFromStockService(Long id);
}
