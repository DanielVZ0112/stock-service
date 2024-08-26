package com.emazon.stockservice;

import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.infrastructure.output.jpa.entity.CategoriaEntity;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CategoriaEntityMapperTest {

    @Autowired
    private CategoriaEntityMapper categoriaEntityMapper;

    @Test
    public void testToCategoriaEntity() {
        // Inicializa la instancia de Categoria
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(1L);
        categoria.setNombreCategoria("Electronics");
        categoria.setDescripcionCategoria("Electronic items");

        // Mapea Categoria a CategoriaEntity
        CategoriaEntity categoriaEntity = categoriaEntityMapper.toCategoriaEntity(categoria);

        // Verifica que CategoriaEntity no sea nulo y los valores sean correctos
        assertNotNull(categoriaEntity);
        assertEquals(categoria.getIdCategoria(), categoriaEntity.getId());
        assertEquals(categoria.getNombreCategoria(), categoriaEntity.getNombre());
        assertEquals(categoria.getDescripcionCategoria(), categoriaEntity.getDescripcion());
    }

    @Test
    public void testToCategoria() {
        // Inicializa la instancia de CategoriaEntity
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(1L);
        categoriaEntity.setNombre("Electronics");
        categoriaEntity.setDescripcion("Electronic items");

        // Mapea CategoriaEntity a Categoria
        Categoria categoria = categoriaEntityMapper.toCategoria(categoriaEntity);

        // Verifica que Categoria no sea nulo y los valores sean correctos
        assertNotNull(categoria);
        assertEquals(categoriaEntity.getId(), categoria.getIdCategoria());
        assertEquals(categoriaEntity.getNombre(), categoria.getNombreCategoria());
        assertEquals(categoriaEntity.getDescripcion(), categoria.getDescripcionCategoria());
    }
}
