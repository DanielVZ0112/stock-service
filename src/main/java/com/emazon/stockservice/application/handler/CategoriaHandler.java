package com.emazon.stockservice.application.handler;

import com.emazon.stockservice.application.dto.CategoriaDTO;
import com.emazon.stockservice.application.mapper.CategoriaDTOMapper;
import com.emazon.stockservice.domain.api.iCategoriaServicePort;
import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaNombreMaximumCharacterExcepcion;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriaHandler implements iCategoriaHandler{

    private final iCategoriaServicePort categorizeServicePort;
    private final CategoriaDTOMapper categoriaDTOMapper;

    @Override
    public void createCategoriaInStockService(CategoriaDTO categoriaDTO) {

        if (categoriaDTO.getNombre().length() > 50) {
            throw new CategoriaNombreMaximumCharacterExcepcion(50);
        }

        Categoria categoria = categoriaDTOMapper.toCategoria(categoriaDTO);

        if (categoria == null || categoria.getNombre() == null || categoria.getDescripcion() == null) {
            throw new RuntimeException("Error al mapear el DTO a la entidad de dominio");
        }

        categorizeServicePort.createCategoria(categoria);
    }

    @Override
    public List<CategoriaDTO> getAllCategoriasFromStockService() {
        List<Categoria> categorias = categorizeServicePort.getAllCategorias();
        System.out.println("Categorias from service port: " + categorias);
        return categoriaDTOMapper.toCategoriaDTOList(categorizeServicePort.getAllCategorias());
    }

    @Override
    public CategoriaDTO getCategoriaFromStockService(Long id) {
        Categoria categoria = categorizeServicePort.getCategoria(id);
        return categoriaDTOMapper.toCategoriaDTO(categoria);
    }

    @Override
    public void updateCategoriaInStckService(CategoriaDTO categoriaDTO) {
        Categoria categoriaExit = categorizeServicePort.getCategoria(categoriaDTO.getId());
        Categoria categoria = categoriaDTOMapper.toCategoria(categoriaDTO);
        categoria.setId(categoriaExit.getId());
        categorizeServicePort.createCategoria(categoria);
    }

    @Override
    public void deleteCategoriaFromStockService(Long id) {
        Categoria categoria = categorizeServicePort.getCategoria(id);
        categorizeServicePort.deleteCategoria(categoria.getId());
    }
}
