package com.emazon.stockservice.domain.spi;

import com.emazon.stockservice.domain.model.Marca;
import com.emazon.stockservice.domain.model.PaginatedResult;

import java.util.List;

public interface iMarcaPersistencePort {

    void createMarca(Marca marca);

    PaginatedResult<Marca> getAllMarca(int page, int size, String sortDirection);

    Marca getMarca(Long id);

    void updateMarca(Marca marca);

    void deleteMarca(Long id);
}
