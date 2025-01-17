package com.emazon.stockservice.infrastructure.output.jpa.adapter;

import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.domain.model.PaginatedResult;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaDuplicateException;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaNotFoundException;
import com.emazon.stockservice.infrastructure.exception.marcaexception.MarcaNotFoundException;
import com.emazon.stockservice.infrastructure.output.jpa.entity.CategoriaEntity;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.emazon.stockservice.infrastructure.output.jpa.repository.iCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class CategoriaJpaAdapter implements iCategoriaPersistencePort {

    private final iCategoriaRepository categoriaRepository;

    private final CategoriaEntityMapper categoriaEntityMapper;

    @Override
    public void createCategoria(Categoria categoria) {
        if(categoriaRepository.findByNombre(categoria.getNombre()).isPresent()){
            throw new CategoriaDuplicateException(categoria.getNombre());
        }
        categoriaRepository.save(categoriaEntityMapper.toCategoriaEntity(categoria));
    }

    @Override
    public PaginatedResult<Categoria> getAllCategorias(int page, int size, String sortDirection) {
        Pageable pageable = PageRequest.of(page, size, sortDirection.equals("asc") ? Sort.by("nombre").ascending() : Sort.by("nombre").descending());
        Page<CategoriaEntity> categoriaPage = categoriaRepository.findAll(pageable);
        if(categoriaPage.isEmpty()){
            throw new CategoriaNotFoundException() ;
        }
        List<Categoria> categoriaList = categoriaPage.map(categoriaEntityMapper::toCategoria).toList();
        return new PaginatedResult<>(categoriaList,categoriaPage.getTotalPages(),categoriaPage.getTotalElements());
    }

    @Override
    public Categoria getCategoria(Long id) {
        return categoriaRepository.findById(id)
                .map(categoriaEntityMapper::toCategoria)
                .orElse(null);
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = categoriaEntityMapper.toCategoriaEntity(categoria);
        categoriaRepository.save(categoriaEntity);
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
