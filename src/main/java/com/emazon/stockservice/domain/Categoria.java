package com.emazon.stockservice.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // O GenerationType.AUTO si prefieres
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private String descripcion;
}
