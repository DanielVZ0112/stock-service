package com.emazon.stockservice.infrastructure.output.jpa.repository;

import com.emazon.stockservice.infrastructure.output.jpa.entity.CategoriaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iCategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    Optional<CategoriaEntity> findByNombre(String nombre);
    Page<CategoriaEntity> findAll(Pageable pageable);
}
