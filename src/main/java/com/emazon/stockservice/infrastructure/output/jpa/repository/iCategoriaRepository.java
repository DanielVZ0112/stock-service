package com.emazon.stockservice.infrastructure.output.jpa.repository;

import com.emazon.stockservice.domain.model.Categoria;
import com.emazon.stockservice.infrastructure.output.jpa.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iCategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    Optional<Categoria> findByNombre(String nombre);
}
