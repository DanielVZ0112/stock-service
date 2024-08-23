package com.emazon.stockservice.application.mapper;

import com.emazon.stockservice.application.dto.CategoriaDTO;
import com.emazon.stockservice.domain.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy =ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoriaDTOMapper {

    CategoriaDTOMapper INSTANCE = Mappers.getMapper(CategoriaDTOMapper.class);

    CategoriaDTO toCategoriaDTO(Categoria categoria);

    Categoria toCategoria(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> toCategoriaDTOList(List<Categoria> categorias);

    List<Categoria> toCategoriaList(List<CategoriaDTO> categoriaDTOs);
}
