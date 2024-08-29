package com.emazon.stockservice.domain.api;

import com.emazon.stockservice.domain.model.Marca;

import java.util.List;

public interface iMarcaServicePort {

    Marca createMarca(Marca marca);

    List<Marca> getAllMarca();

    Marca getMarca(Long id);

    void updateMarca(Marca marca);

    void deleteMarca(Long id);
}
