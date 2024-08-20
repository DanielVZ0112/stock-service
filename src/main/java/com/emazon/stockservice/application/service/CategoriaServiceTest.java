package com.emazon.stockservice.application.service;

import com.emazon.stockservice.domain.Categoria;
import com.emazon.stockservice.infrastructure.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.emazon.stockservice.exception.CategoriaDuplicateException;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
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
        categoria.setDescripcion("Ropa para hombres, mujeres y niños, incluyendo camisas, pantalones, abrigos y más.");

        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria result = categoriaService.createCategoria(categoria);

        assertEquals("Ropa", result.getNombre());
        assertEquals("Ropa para hombres, mujeres y niños, incluyendo camisas, pantalones, abrigos y más.", result.getDescripcion());
        verify(categoriaRepository).save(categoria);
    }
    @Test
    public void testCreateCategoria_AlreadyExists() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Ropa");
        categoria.setDescripcion("Ropa para hombres, mujeres y niños, incluyendo camisas, pantalones, abrigos y más.");

        when(categoriaRepository.existsByNombre(any(String.class))).thenReturn(true);

        // Usa assertThrows para verificar que se lanza la excepción esperada
        CategoriaDuplicateException thrown = Assertions.assertThrows(
                CategoriaDuplicateException.class,
                () -> categoriaService.createCategoria(categoria),
                "Expected createCategoria() to throw CategoriaYaExisteException, but it didn't"
        );

        assertEquals("La categoría con nombre 'Ropa' ya existe.", thrown.getMessage());
    }
}
