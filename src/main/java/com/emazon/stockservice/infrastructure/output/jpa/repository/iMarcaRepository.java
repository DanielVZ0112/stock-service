package com.emazon.stockservice.infrastructure.output.jpa.repository;

import com.emazon.stockservice.infrastructure.output.jpa.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iMarcaRepository extends JpaRepository <MarcaEntity, Long> {
    Optional<MarcaEntity> findByNombre(String nombre);
}
