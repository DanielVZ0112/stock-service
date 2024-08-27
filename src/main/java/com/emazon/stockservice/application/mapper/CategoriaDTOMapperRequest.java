package com.emazon.stockservice.application.mapper;

import com.emazon.stockservice.application.dto.CategoriaDTORequest;
import com.emazon.stockservice.domain.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaDTOMapperRequest {
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    Categoria toCategoria(CategoriaDTORequest categoriaDTORequest);
}
