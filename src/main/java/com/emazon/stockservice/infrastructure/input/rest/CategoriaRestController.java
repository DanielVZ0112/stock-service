package com.emazon.stockservice.infrastructure.input.rest;


import com.emazon.stockservice.application.dto.CategoriaDTO;
import com.emazon.stockservice.application.handler.iCategoriaHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@RequiredArgsConstructor
public class CategoriaRestController {
    private final iCategoriaHandler categoriaHandler;

    @PostMapping("/add")
    public ResponseEntity<Void> createCategoriaInStockService(@RequestBody CategoriaDTO categoriaDTO) {

        categoriaHandler.createCategoriaInStockService(categoriaDTO);
        return ResponseEntity.status(201).build();
    }
    @GetMapping("/")
    public ResponseEntity<List<CategoriaDTO>> getAllCategoriasFromStockService(){
        return ResponseEntity.ok(categoriaHandler.getAllCategoriasFromStockService());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaFromStockService(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(categoriaHandler.getCategoriaFromStockService(id));
    }
    @PutMapping("/")
    public ResponseEntity<Void> updateCategoriaFromStockService(@RequestBody CategoriaDTO categoriaDTO){
        categoriaHandler.updateCategoriaInStckService(categoriaDTO);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoriaFromStockService(@PathVariable(name="id") Long id){
        categoriaHandler.deleteCategoriaFromStockService(id);
        return ResponseEntity.noContent().build();
    }
}
