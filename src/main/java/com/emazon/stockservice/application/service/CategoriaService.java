package com.emazon.stockservice.application.service;

import com.emazon.stockservice.domain.Categoria;
import com.emazon.stockservice.exception.CategoriaDuplicadaException;
import com.emazon.stockservice.infratructure.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria createCategoria(Categoria categoria) {

        Optional<Categoria> existingCategoria = categoriaRepository.findByNombre(categoria.getNombre());

        if (existingCategoria.isPresent()) {
            throw new CategoriaDuplicadaException("La categoría con nombre '" + categoria.getNombre() + "' ya existe.");
        }
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
