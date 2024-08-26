package com.emazon.stockservice.application.mapper;

import com.emazon.stockservice.application.dto.CategoriaDTO;
import com.emazon.stockservice.domain.model.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaDTOMapper {
    CategoriaDTO toCategoriaDTO(Categoria categoria);
    Categoria toCategoria(CategoriaDTO categoriaDTO);
    List<CategoriaDTO> toCategoriaDTOList(List<Categoria> categoria);
}

