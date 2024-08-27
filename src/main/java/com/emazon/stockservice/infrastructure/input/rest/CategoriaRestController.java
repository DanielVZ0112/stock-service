package com.emazon.stockservice.infrastructure.input.rest;

import com.emazon.stockservice.application.dto.CategoriaDTORequest;
import com.emazon.stockservice.application.dto.CategoriaDTOResponse;
import com.emazon.stockservice.application.handler.iCategoriaHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@Tag(name = "Categorías", description = "Operaciones relacionadas con las categorías")
@RequiredArgsConstructor
public class CategoriaRestController {
    private final iCategoriaHandler categoriaHandler;

    @PostMapping("/add")
    @Operation(summary = "Crear una nueva categoría")
    @ApiResponse(responseCode = "201", description = "Categoría creada con éxito")
    public ResponseEntity<Void> createCategoriaInStockService(@Valid @RequestBody CategoriaDTORequest categoriaDTORequest) {
        categoriaHandler.createCategoriaInStockService(categoriaDTORequest);
        return ResponseEntity.status(201).build();
    }
    @GetMapping("/getAll")
    @Operation(summary = "Obtener todas las categorías")
    public ResponseEntity<List<CategoriaDTOResponse>> getAllCategoriasFromStockService(){
        return ResponseEntity.ok(categoriaHandler.getAllCategoriasFromStockService());
    }
    @GetMapping("/getBy/{id}")
    @Operation(summary = "Obtener una categoria por su id")
    public ResponseEntity<CategoriaDTOResponse> getCategoriaFromStockService(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(categoriaHandler.getCategoriaFromStockService(id));
    }
    @PutMapping("/update")
    @Operation(summary = "Actualiza la categoria seleccionada")
    public ResponseEntity<Void> updateCategoriaFromStockService(@RequestBody CategoriaDTORequest categoriaDTORequest){
        categoriaHandler.updateCategoriaInStckService(categoriaDTORequest);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina la categoria por su id")
    public ResponseEntity<Void> deleteCategoriaFromStockService(@PathVariable(name="id") Long id){
        categoriaHandler.deleteCategoriaFromStockService(id);
        return ResponseEntity.noContent().build();
    }
}
