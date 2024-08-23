package com.emazon.stockservice;

import com.emazon.stockservice.application.CategoriaService;
import com.emazon.stockservice.domain.Categoria;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaDuplicateException;
import com.emazon.stockservice.infrastructure.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

public class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Ropa");
        categoria.setDescripcion("Descripción");

        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria result = categoriaService.createCategoria(categoria);

        assertEquals("Ropa", result.getNombre());
        assertEquals("Descripción", result.getDescripcion());
        verify(categoriaRepository).save(categoria);
    }

    @Test
    public void testCreateCategoria_AlreadyExists() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Ropa");
        categoria.setDescripcion("Descripción");

        when(categoriaRepository.existsByNombre(any(String.class))).thenReturn(true);

        CategoriaDuplicateException thrown = Assertions.assertThrows(
                CategoriaDuplicateException.class,
                () -> categoriaService.createCategoria(categoria)
        );

        assertEquals("La categoría con nombre 'Ropa' ya existe.", thrown.getMessage());
    }
    @Test
    public void testGetCategoriaById() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Electronics");
        categoria.setDescripcion("Electronics items");

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));

        Categoria result = categoriaService.getCategoriaById(1L).orElse(null);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Electronics", result.getNombre());
    }

    @Test
    public void testDeleteCategoria() {
        categoriaService.deleteCategoria(1L);
        verify(categoriaRepository).deleteById(1L);
    }
}
