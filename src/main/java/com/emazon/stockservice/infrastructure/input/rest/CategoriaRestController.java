package com.emazon.stockservice.infrastructure.input.rest;

import com.emazon.stockservice.application.dto.CategoriaDTORequest;
import com.emazon.stockservice.application.dto.CategoriaDTOResponse;
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
    public ResponseEntity<Void> createCategoriaInStockService(@RequestBody CategoriaDTORequest categoriaDTORequest) {
        categoriaHandler.createCategoriaInStockService(categoriaDTORequest);
        return ResponseEntity.status(201).build();
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoriaDTOResponse>> getAllCategoriasFromStockService(){
        return ResponseEntity.ok(categoriaHandler.getAllCategoriasFromStockService());
    }
    @GetMapping("/getBy/{id}")
    public ResponseEntity<CategoriaDTOResponse> getCategoriaFromStockService(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(categoriaHandler.getCategoriaFromStockService(id));
    }
    @PutMapping("/update")
    public ResponseEntity<Void> updateCategoriaFromStockService(@RequestBody CategoriaDTORequest categoriaDTORequest){
        categoriaHandler.updateCategoriaInStckService(categoriaDTORequest);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategoriaFromStockService(@PathVariable(name="id") Long id){
        categoriaHandler.deleteCategoriaFromStockService(id);
        return ResponseEntity.noContent().build();
    }
}
