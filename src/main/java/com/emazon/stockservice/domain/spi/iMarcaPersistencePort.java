package com.emazon.stockservice.domain.spi;

import com.emazon.stockservice.domain.model.Marca;

import java.util.List;

public interface iMarcaPersistencePort {

    void createMarca(Marca marca);

    List<Marca> getAllMarca();

    Marca getMarca(Long id);

    void updateMarca(Marca marca);

    void deleteMarca(Long id);
}
