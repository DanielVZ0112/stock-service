package com.emazon.stockservice.infrastructure.output.jpa.adapter;

import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaDescripcionMaximumCharacterException;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaDuplicateException;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaNombreMaximumCharacterExcepcion;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaNotFoundException;
import com.emazon.stockservice.infrastructure.output.jpa.entity.CategoriaEntity;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.emazon.stockservice.infrastructure.output.jpa.repository.iCategoriaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoriaJpaAdapter implements iCategoriaPersistencePort {

    private final iCategoriaRepository categoriaRepository;

    private final CategoriaEntityMapper categoriaEntityMapper;

    @Override
    public void createCategoria(Categoria categoria) {
        int maximoNumeroNombreCategorias = 50;
        if (categoria.getNombre() == null || categoria.getNombre().length() > maximoNumeroNombreCategorias) {
            throw new CategoriaNombreMaximumCharacterExcepcion(maximoNumeroNombreCategorias);
        }
        int maximoNumeroDescripcionCategorias = 90;
        if (categoria.getDescripcion() != null && categoria.getDescripcion().length() > maximoNumeroDescripcionCategorias) {
            throw new CategoriaDescripcionMaximumCharacterException(maximoNumeroDescripcionCategorias);
        }
        if(categoriaRepository.findByNombre(categoria.getNombre()).isPresent()){
            throw new CategoriaDuplicateException(categoria.getNombre());
        }
        categoriaRepository.save(categoriaEntityMapper.toCategoriaEntity(categoria));
    }

    @Override
    public List<Categoria> getAllCategorias() {
        List<CategoriaEntity> categoriaEntityList = categoriaRepository.findAll();
        if(categoriaEntityList.isEmpty()){
            throw new CategoriaNotFoundException();
        }
        return categoriaEntityMapper.toCategoriaList(categoriaEntityList);
    }

    @Override
    public Categoria getCategoria(Long id) {
        return categoriaEntityMapper.toCategoria(categoriaRepository.findById(id).orElseThrow(CategoriaNotFoundException::new));
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        categoriaRepository.save(categoriaEntityMapper.toCategoriaEntity(categoria));
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
