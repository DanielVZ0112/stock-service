package com.emazon.stockservice.marcaTest;

import com.emazon.stockservice.domain.model.Marca;
import com.emazon.stockservice.infrastructure.output.jpa.entity.MarcaEntity;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MarcaEntityMapperTest {

    @Autowired
    private MarcaEntityMapper mapper;

    @Test
    void testToMarcaEntity() {
        Marca marca = new Marca(1L, "Samsung", "Marca de dispositivos electrónicos");

        MarcaEntity marcaEntity = mapper.toMarcaEntity(marca);

        assertNotNull(marcaEntity);
        assertEquals(marca.getId(), marcaEntity.getId());
        assertEquals(marca.getNombre(), marcaEntity.getNombre());
        assertEquals(marca.getDescripcion(), marcaEntity.getDescripcion());
    }

    @Test
    void testToMarca() {
        MarcaEntity marcaEntity = new MarcaEntity(1L, "Samsung", "Marca de dispositivos electrónicos");

        Marca marca = mapper.toMarca(marcaEntity);

        assertNotNull(marca);
        assertEquals(marcaEntity.getId(), marca.getId());
        assertEquals(marcaEntity.getNombre(), marca.getNombre());
        assertEquals(marcaEntity.getDescripcion(), marca.getDescripcion());
    }

    @Test
    void testToMarcaList() {
        MarcaEntity marcaEntity1 = new MarcaEntity(1L, "Samsung", "Marca de dispositivos electrónicos");
        MarcaEntity marcaEntity2 = new MarcaEntity(2L, "Apple", "Marca de tecnología avanzada");
        List<MarcaEntity> marcaEntityList = Arrays.asList(marcaEntity1, marcaEntity2);

        List<Marca> marcaList = mapper.toMarcaList(marcaEntityList);

        assertNotNull(marcaList);
        assertEquals(2, marcaList.size());

        Marca marca1 = marcaList.get(0);
        Marca marca2 = marcaList.get(1);

        assertEquals(marcaEntity1.getId(), marca1.getId());
        assertEquals(marcaEntity1.getNombre(), marca1.getNombre());
        assertEquals(marcaEntity1.getDescripcion(), marca1.getDescripcion());

        assertEquals(marcaEntity2.getId(), marca2.getId());
        assertEquals(marcaEntity2.getNombre(), marca2.getNombre());
        assertEquals(marcaEntity2.getDescripcion(), marca2.getDescripcion());
    }
}
