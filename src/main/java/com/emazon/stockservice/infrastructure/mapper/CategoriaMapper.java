package com.emazon.stockservice.infrastructure.mapper;

import com.emazon.stockservice.domain.Categoria;
import com.emazon.stockservice.infrastructure.dto.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO toCategoriaDTO(Categoria categoria);

    Categoria toCategoria(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> toCategoriaDTOList(List<Categoria> categorias);

    List<Categoria> toCategoriaList(List<CategoriaDTO> categoriaDTOs);
}
