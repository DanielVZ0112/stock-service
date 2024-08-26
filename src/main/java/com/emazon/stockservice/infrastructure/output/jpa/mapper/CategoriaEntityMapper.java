package com.emazon.stockservice.infrastructure.output.jpa.mapper;


import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.infrastructure.output.jpa.entity.CategoriaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaEntityMapper {
    CategoriaEntity toCategoriaEntity(Categoria categoria);
    Categoria toCategoria(CategoriaEntity categoriaEntity);
    List<Categoria> toCategoriaList(List<CategoriaEntity> categoriasEntityList);
    List<CategoriaEntity> toCategoriaEntityList(List<Categoria> categorias);
}
