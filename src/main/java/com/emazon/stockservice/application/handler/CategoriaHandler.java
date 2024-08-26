package com.emazon.stockservice.application.handler;

import com.emazon.stockservice.application.dto.CategoriaDTORequest;
import com.emazon.stockservice.application.dto.CategoriaDTOResponse;
import com.emazon.stockservice.application.mapper.CategoriaDTOMapperRequest;
import com.emazon.stockservice.application.mapper.CategoriaDTOMapperResponse;
import com.emazon.stockservice.domain.api.iCategoriaServicePort;
import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaNombreMaximumCharacterExcepcion;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriaHandler implements iCategoriaHandler {

    private final iCategoriaServicePort categorizeServicePort;
    private final CategoriaDTOMapperResponse categoriaDTOMapperResponse;
    private final CategoriaDTOMapperRequest categoriaDTOMapperRequest;

    @Override
    public void createCategoriaInStockService(CategoriaDTORequest categoriaDTORequest) {
        if (categoriaDTORequest.getNombre().length() > 50) {
            throw new CategoriaNombreMaximumCharacterExcepcion(50);
        }

        Categoria categoria = categoriaDTOMapperRequest.toCategoria(categoriaDTORequest);

        if (categoria == null || categoria.getNombre() == null || categoria.getDescripcion() == null) {
            throw new CategoriaNotFoundException();
        }

        categorizeServicePort.createCategoria(categoria);
    }

    @Override
    public List<CategoriaDTOResponse> getAllCategoriasFromStockService() {
        List<Categoria> categoria = categorizeServicePort.getAllCategorias();
        return categoriaDTOMapperResponse.toCategoriaDTOResponseList(categoria);
    }

    @Override
    public CategoriaDTOResponse getCategoriaFromStockService(Long id) {
        Categoria categoria = categorizeServicePort.getCategoria(id);
        if (categoria == null) {
            throw new CategoriaNotFoundException();
        }
        return categoriaDTOMapperResponse.toCategoriaDTOResponse(categoria);
    }

    @Override
    public void updateCategoriaInStckService(CategoriaDTORequest categoriaDTORequest) {
        if (categoriaDTORequest.getId() == null) {
            throw new CategoriaNotFoundException();
        }

        Categoria categoriaExit = categorizeServicePort.getCategoria(categoriaDTORequest.getId());
        if (categoriaExit == null) {
            throw new CategoriaNotFoundException();
        }

        Categoria newCategoria = categoriaDTOMapperRequest.toCategoria(categoriaDTORequest);
        newCategoria.setId(categoriaExit.getId());
        categorizeServicePort.updateCategoria(newCategoria);
    }

    @Override
    public void deleteCategoriaFromStockService(Long id) {
        Categoria categoria = categorizeServicePort.getCategoria(id);
        if (categoria == null) {
            throw new CategoriaNotFoundException();
        }
        categorizeServicePort.deleteCategoria(id);
    }
}
