package com.emazon.stockservice.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name="categoria")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    @NonNull
    @NotBlank
    @Size(min = 5, max = 50)
    private String nombre;
    @NonNull
    @Size(min = 5, max = 90)
    private String descripcion;
}
