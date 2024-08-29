package com.emazon.stockservice.infrastructure.input.rest;

import com.emazon.stockservice.application.dto.CategoriaDTORequest;
import com.emazon.stockservice.application.dto.CategoriaDTOResponse;
import com.emazon.stockservice.application.handler.iCategoriaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria/")
@RequiredArgsConstructor
public class CategoriaRestController {
    private final iCategoriaHandler categoriaHandler;
    @PostMapping("add")
    @Operation(summary = "Crear una nueva categoría")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoría creada"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta", content = @Content)
    })
    public ResponseEntity<Void> createCategoriaInStockService(@RequestBody CategoriaDTORequest categoriaDTORequest) {
        categoriaHandler.createCategoriaInStockService(categoriaDTORequest);
        return ResponseEntity.status(201).build();
    }
    @GetMapping("getAll")
    @Operation(summary = "Listar todas las categorías con paginación y orden")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de categorías obtenida correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class)))
    })
    public ResponseEntity<Page<CategoriaDTOResponse>> getAllCategoriasFromStockService(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        Pageable pageable = PageRequest.of(page, size, sortDirection.equals("asc") ? Sort.by("nombre").ascending() : Sort.by("nombre").descending());
        return ResponseEntity.ok(categoriaHandler.getAllCategoriasFromStockService(pageable));
    }
    @GetMapping("getBy/{id}")
    @Operation(summary = "Obtener una categoría por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoría obtenida correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaDTOResponse.class))),
            @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
    })
    public ResponseEntity<CategoriaDTOResponse> getCategoriaFromStockService(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(categoriaHandler.getCategoriaFromStockService(id));
    }
    @PutMapping("update")
    @Operation(summary = "Actualizar una categoría existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoría actualizada"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta", content = @Content)
    })
    public ResponseEntity<Void> updateCategoriaFromStockService(@RequestBody CategoriaDTORequest categoriaDTORequest){
        categoriaHandler.updateCategoriaInStockService(categoriaDTORequest);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("delete/{id}")
    @Operation(summary = "Eliminar una categoría por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoría eliminada"),
            @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
    })
    public ResponseEntity<Void> deleteCategoriaFromStockService(@PathVariable(name="id") Long id){
        categoriaHandler.deleteCategoriaFromStockService(id);
        return ResponseEntity.noContent().build();
    }
}
