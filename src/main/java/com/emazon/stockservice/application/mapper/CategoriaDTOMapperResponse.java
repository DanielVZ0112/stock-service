package com.emazon.stockservice.application.mapper;

import com.emazon.stockservice.application.dto.CategoriaDTOResponse;
import com.emazon.stockservice.domain.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaDTOMapperResponse {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    CategoriaDTOResponse toCategoriaDTOResponse(Categoria categoria);

    List<CategoriaDTOResponse> toCategoriaDTOResponseList(List<Categoria> categorias);

    default Page<CategoriaDTOResponse> toCategoriaDTOResponsePage(List<Categoria> categoriaList) {
        return new PageImpl<>(toCategoriaDTOResponseList(categoriaList));
    }

    
}