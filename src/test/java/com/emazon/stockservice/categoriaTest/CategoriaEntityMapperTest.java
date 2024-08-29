package com.emazon.stockservice.categoriaTest;

import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.infrastructure.output.jpa.entity.CategoriaEntity;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CategoriaEntityMapperTest {

    @Autowired
    private CategoriaEntityMapper mapper;

    @Test
    void testToCategoriaEntity() {
        Categoria categoria = new Categoria(1L, "Electrónica", "Productos tecnológicos");

        CategoriaEntity categoriaEntity = mapper.toCategoriaEntity(categoria);

        assertNotNull(categoriaEntity);
        assertEquals(categoria.getId(), categoriaEntity.getId());
        assertEquals(categoria.getNombre(), categoriaEntity.getNombre());
        assertEquals(categoria.getDescripcion(), categoriaEntity.getDescripcion());
    }

    @Test
    void testToCategoria() {
        CategoriaEntity categoriaEntity = new CategoriaEntity(1L, "Electrónica", "Productos tecnológicos");

        Categoria categoria = mapper.toCategoria(categoriaEntity);

        assertNotNull(categoria);
        assertEquals(categoriaEntity.getId(), categoria.getId());
        assertEquals(categoriaEntity.getNombre(), categoria.getNombre());
        assertEquals(categoriaEntity.getDescripcion(), categoria.getDescripcion());
    }

    @Test
    void testToCategoriaList() {
        CategoriaEntity categoriaEntity1 = new CategoriaEntity(1L, "Electrónica", "Productos tecnológicos");
        CategoriaEntity categoriaEntity2 = new CategoriaEntity(2L, "Ropa", "Ropa y accesorios");
        List<CategoriaEntity> categoriaEntityList = Arrays.asList(categoriaEntity1, categoriaEntity2);

        List<Categoria> categoriaList = mapper.toCategoriaList(categoriaEntityList);

        assertNotNull(categoriaList);
        assertEquals(2, categoriaList.size());

        Categoria categoria1 = categoriaList.get(0);
        Categoria categoria2 = categoriaList.get(1);

        assertEquals(categoriaEntity1.getId(), categoria1.getId());
        assertEquals(categoriaEntity1.getNombre(), categoria1.getNombre());
        assertEquals(categoriaEntity1.getDescripcion(), categoria1.getDescripcion());

        assertEquals(categoriaEntity2.getId(), categoria2.getId());
        assertEquals(categoriaEntity2.getNombre(), categoria2.getNombre());
        assertEquals(categoriaEntity2.getDescripcion(), categoria2.getDescripcion());
    }
}
