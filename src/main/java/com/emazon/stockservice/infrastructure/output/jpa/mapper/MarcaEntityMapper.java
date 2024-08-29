package com.emazon.stockservice.infrastructure.output.jpa.mapper;

import com.emazon.stockservice.domain.model.Marca;
import com.emazon.stockservice.infrastructure.output.jpa.entity.MarcaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarcaEntityMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    MarcaEntity toMarcaEntity(Marca marca);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    Marca toMarca(MarcaEntity marcaEntity);

    List<Marca> toMarcaList(List<MarcaEntity> marcaEntityList);
}
