package com.emazon.stockservice.categoriaTest;

import com.emazon.stockservice.application.dto.CategoriaDTORequest;
import com.emazon.stockservice.application.mapper.CategoriaDTOMapperRequest;
import com.emazon.stockservice.domain.model.Categoria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CategoriaDTOMapperRequestTest {
    @Autowired
    private CategoriaDTOMapperRequest mapper;

    @Test
    void testToCategoria() {
        CategoriaDTORequest dtoRequest = new CategoriaDTORequest();
        dtoRequest.setId(1L);
        dtoRequest.setNombre("Electrónica");
        dtoRequest.setDescripcion("Productos tecnológicos");

        Categoria categoria = mapper.toCategoria(dtoRequest);

        assertNotNull(categoria);
        assertEquals(dtoRequest.getId(), categoria.getId());
        assertEquals(dtoRequest.getNombre(), categoria.getNombre());
        assertEquals(dtoRequest.getDescripcion(), categoria.getDescripcion());
    }

}