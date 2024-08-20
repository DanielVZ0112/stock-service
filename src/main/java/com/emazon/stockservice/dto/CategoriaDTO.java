package com.emazon.stockservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}
