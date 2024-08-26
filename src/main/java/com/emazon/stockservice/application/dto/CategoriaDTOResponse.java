package com.emazon.stockservice.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTOResponse {
    private Long id;
    private String nombre;
    private String descripcion;
}
