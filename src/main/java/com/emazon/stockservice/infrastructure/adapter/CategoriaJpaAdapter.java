package com.emazon.stockservice.infrastructure.adapter;

import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaDuplicateException;
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
        if (categoria.getNombre() == null || categoria.getNombre().length() > 50) {
            throw new IllegalArgumentException("El nombre de la categoría debe tener un máximo de 50 caracteres.");
        }
        if (categoria.getDescripcion() != null && categoria.getDescripcion().length() > 90) {
            throw new IllegalArgumentException("La descripción de la categoría debe tener un máximo de 90 caracteres.");
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
        return categoriaEntityMapper.toCategoria(categoriaRepository.findById(id).orElseThrow());
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        categoriaRepository.save(categoriaEntityMapper.toCategoriaEntity(categoria));
    }

    @Override
    public void deleteCategoria(Long id) {
        CategoriaEntity  categoriaEntity = categoriaRepository.findById(id).orElseThrow();
        categoriaRepository.deleteById(categoriaEntity.getId());
    }
}
