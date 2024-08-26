package com.emazon.stockservice.infrastructure.output.jpa.repository;

import com.emazon.stockservice.infrastructure.output.jpa.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iCategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    Optional<CategoriaEntity> findByNombre(String nombre);

    void deleteByNombre(String nombre);
}
