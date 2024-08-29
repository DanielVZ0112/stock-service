package com.emazon.stockservice.application.mapper;

import com.emazon.stockservice.application.dto.MarcaDTOResponse;
import com.emazon.stockservice.domain.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarcaDTOMapperResponse {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    MarcaDTOResponse toMarcaDTOResponse(Marca marca);

    List<MarcaDTOResponse> toMarcaDTOResponseList(List<Marca> marca);


}
