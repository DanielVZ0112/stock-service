package com.emazon.stockservice.marcaTest;

import com.emazon.stockservice.domain.model.Marca;
import com.emazon.stockservice.domain.model.PaginatedResult;
import com.emazon.stockservice.domain.spi.iMarcaPersistencePort;
import com.emazon.stockservice.domain.usecase.MarcaUseCase;
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

class MarcaUseCaseTest {

    @Mock
    private iMarcaPersistencePort marcaPersistencePort;

    @InjectMocks
    private MarcaUseCase marcaUseCase;

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
    void testGetAllMarcas(int inputPageNumber, int inputPageSize, String inputSortDirection,
                          int expectedPageNumber, int expectedPageSize, String expectedSortDirection) {

        List<Marca> marcaList = new ArrayList<>();
        marcaList.add(new Marca(1L, "Marca 1","Descripcion 1"));
        marcaList.add(new Marca(2L, "Marca 2","Descripcion 2"));

        PaginatedResult<Marca> expectedMarcas = new PaginatedResult<>(marcaList, expectedPageNumber, expectedPageSize);

        when(marcaPersistencePort.getAllMarca(expectedPageNumber, expectedPageSize, expectedSortDirection))
                .thenReturn(expectedMarcas);

        PaginatedResult<Marca> result = marcaUseCase.getAllMarca(inputPageNumber, inputPageSize, inputSortDirection);

        assertEquals(expectedMarcas, result);
        verify(marcaPersistencePort).getAllMarca(expectedPageNumber, expectedPageSize, expectedSortDirection);
    }
}
