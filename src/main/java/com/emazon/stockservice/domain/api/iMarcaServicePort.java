package com.emazon.stockservice.domain.api;

import com.emazon.stockservice.domain.model.Marca;
import com.emazon.stockservice.domain.model.PaginatedResult;

import java.util.List;

public interface iMarcaServicePort {

    void createMarca(Marca marca);

    PaginatedResult<Marca> getAllMarca(int pageNumber, int pageSize, String sortDirection);

    Marca getMarca(Long id);

    void updateMarca(Marca marca);

    void deleteMarca(Long id);
}
