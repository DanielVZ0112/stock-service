package com.emazon.stockservice.categoriaTest;

import com.emazon.stockservice.domain.model.PaginatedResult;
import com.emazon.stockservice.domain.usecase.CategoriaUseCase;
import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CategoriaUseCaseTest {

    @Mock
    private iCategoriaPersistencePort categoriaPersistencePort;

    @InjectMocks
    private CategoriaUseCase categoriaUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 10, asc, 0, 10, asc",
            "-1, 10, asc, 0, 10, asc",
            "0, 10, invalid, 0, 10, asc",
            "0, 0, asc, 0, 10, asc"
    })
    void testGetAllCategorias(int inputPageNumber, int inputPageSize, String inputSortDirection,
                              int expectedPageNumber, int expectedPageSize, String expectedSortDirection) {

        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(new Categoria(1L, "Categoría 1", "Descripción 1"));
        categoriaList.add(new Categoria(2L, "Categoría 2", "Descripción 2"));

        PaginatedResult<Categoria> expectedCategorias = new PaginatedResult<>(categoriaList, expectedPageNumber, expectedPageSize);

        when(categoriaPersistencePort.getAllCategorias(expectedPageNumber, expectedPageSize, expectedSortDirection))
                .thenReturn(expectedCategorias);

        PaginatedResult<Categoria> result = categoriaUseCase.getAllCategorias(inputPageNumber, inputPageSize, inputSortDirection);

        assertEquals(expectedCategorias, result);
        verify(categoriaPersistencePort).getAllCategorias(expectedPageNumber, expectedPageSize, expectedSortDirection);
    }
}
