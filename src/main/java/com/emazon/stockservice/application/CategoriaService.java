package com.emazon.stockservice.application;

import com.emazon.stockservice.domain.Categoria;
import com.emazon.stockservice.infrastructure.categoriaException.CategoriaDuplicateException;
import com.emazon.stockservice.application.dto.CategoriaDTO;
import com.emazon.stockservice.infrastructure.mapper.CategoriaMapper;
import com.emazon.stockservice.infrastructure.repository.CategoriaRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    @Getter
    private final CategoriaMapper categoriaMapper;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public Page<CategoriaDTO> listarCategorias(int page, int size, String sortBy, String order) {
        Sort sort = Sort.by(sortBy);
        sort = order.equalsIgnoreCase("desc") ? sort.descending() : sort.ascending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Categoria> categorias = categoriaRepository.findAll(pageRequest);

        return categorias.map(categoriaMapper::toCategoriaDTO);
    }

    public Categoria createCategoria(Categoria categoria) {
        Optional<Categoria> existingCategoria = categoriaRepository.findByNombre(categoria.getNombre());
//Capa de domain mover
        if (categoria.getNombre() == null || categoria.getNombre().length() > 50) {
            throw new IllegalArgumentException("El nombre de la categoría debe tener un máximo de 50 caracteres.");
        }
        if (categoria.getDescripcion() != null && categoria.getDescripcion().length() > 90) {
            throw new IllegalArgumentException("La descripción de la categoría debe tener un máximo de 90 caracteres.");
        }
        if (existingCategoria.isPresent()) {
            throw new CategoriaDuplicateException("La categoría con nombre '" + categoria.getNombre() + "' ya existe.");
        }
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
