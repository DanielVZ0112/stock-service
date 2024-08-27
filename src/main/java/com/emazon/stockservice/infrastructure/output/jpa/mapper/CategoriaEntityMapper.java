package com.emazon.stockservice.infrastructure.output.jpa.mapper;


import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.infrastructure.output.jpa.entity.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaEntityMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    CategoriaEntity toCategoriaEntity(Categoria categoria);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    Categoria toCategoria(CategoriaEntity categoriaEntity);

    List<Categoria> toCategoriaList(List<CategoriaEntity> categoriasEntityList);
}

