package com.emazon.stockservice.application.mapper;

import com.emazon.stockservice.application.dto.CategoriaDTOResponse;
import com.emazon.stockservice.domain.model.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaDTOMapperResponse {
    CategoriaDTOResponse toCategoriaDTOResponse(Categoria categoria);

    List<CategoriaDTOResponse> toCategoriaDTOResponseList(List<Categoria> categoria);
}