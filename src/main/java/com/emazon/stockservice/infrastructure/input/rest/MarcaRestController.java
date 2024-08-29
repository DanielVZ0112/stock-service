package com.emazon.stockservice.infrastructure.input.rest;

import com.emazon.stockservice.application.dto.CategoriaDTOResponse;
import com.emazon.stockservice.application.dto.MarcaDTORequest;
import com.emazon.stockservice.application.dto.MarcaDTOResponse;
import com.emazon.stockservice.application.handler.iMarcaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca/")
@RequiredArgsConstructor
public class MarcaRestController {

    private final iMarcaHandler marcaHandler;
    @PostMapping("add")
    @Operation(summary = "Crear una nueva marca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Marca creada"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta", content = @Content)
    })
    public ResponseEntity<Void> createMarcaInStockService(@RequestBody MarcaDTORequest marcaDTORequest) {
        marcaHandler.createMarcaInStockService(marcaDTORequest);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("getAll")
    @Operation(summary = "Listar todas las categorías con paginación y orden")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de categorías obtenida correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class)))
    })
    public ResponseEntity<List<MarcaDTOResponse>> getAllCategoriasFromStockService() {
        return ResponseEntity.ok(marcaHandler.getAllMarcaFromStockService());
    }
    @GetMapping("getBy/{id}")
    @Operation(summary = "Obtener una categoría por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoría obtenida correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaDTOResponse.class))),
            @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
    })
    public ResponseEntity<MarcaDTOResponse> getMarcaFromStockService(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(marcaHandler.getMarcaFromStockService(id));
    }

    @PutMapping("update")
    @Operation(summary = "Actualizar una marca existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Marca actualizada"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta", content = @Content)
    })
    public ResponseEntity<Void> updateMarcaFromStockService(@RequestBody MarcaDTORequest marcaDTORequest){
        marcaHandler.updateMarcaInStockService(marcaDTORequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "Eliminar una marca por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Marca eliminada"),
            @ApiResponse(responseCode = "404", description = "Marca no encontrada", content = @Content)
    })
    public ResponseEntity<Void> deleteMarcaFromStockService(@PathVariable(name="id") Long id){
        marcaHandler.deleteMarcaFromStockService(id);
        return ResponseEntity.noContent().build();
    }
}
