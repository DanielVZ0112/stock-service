package com.emazon.stockservice.marcaTest;

import com.emazon.stockservice.application.dto.MarcaDTORequest;
import com.emazon.stockservice.application.mapper.MarcaDTOMapperRequest;
import com.emazon.stockservice.domain.model.Marca;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MarcaDTOMapperRequestTest {
    @Autowired
    private MarcaDTOMapperRequest mapper;

    @Test
    void testToMarca() {
        MarcaDTORequest dtoRequest = new MarcaDTORequest();
        dtoRequest.setId(1L);
        dtoRequest.setNombre("Samsung");
        dtoRequest.setDescripcion("Marca de dispositivos electrónicos");

        Marca marca = mapper.toMarca(dtoRequest);

        assertNotNull(marca);
        assertEquals(dtoRequest.getId(), marca.getId());
        assertEquals(dtoRequest.getNombre(), marca.getNombre());
        assertEquals(dtoRequest.getDescripcion(), marca.getDescripcion());
    }
}
