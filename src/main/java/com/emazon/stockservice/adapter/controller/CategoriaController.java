package com.emazon.stockservice.adapter.controller;

import com.emazon.stockservice.application.CategoriaService;
import com.emazon.stockservice.domain.Categoria;
import com.emazon.stockservice.application.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public Page<CategoriaDTO> listarCategorias(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nombre") String sortBy,
            @RequestParam(defaultValue = "asc") String order) {

        return categoriaService.listarCategorias(page, size, sortBy, order);
    }

    @GetMapping("/{id}")
    public CategoriaDTO getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id)
                .map(categoria -> categoriaService.getCategoriaMapper().toCategoriaDTO(categoria))
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    @PostMapping
    public CategoriaDTO createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaService.getCategoriaMapper().toCategoria(categoriaDTO);
        Categoria createdCategoria = categoriaService.createCategoria(categoria);
        return categoriaService.getCategoriaMapper().toCategoriaDTO(createdCategoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }
}
