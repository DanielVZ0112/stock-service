package com.emazon.stockservice.application.mapper;

import com.emazon.stockservice.application.dto.MarcaDTORequest;
import com.emazon.stockservice.domain.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MarcaDTOMapperRequest {
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    Marca toMarca(MarcaDTORequest marcaDTORequest);
}
