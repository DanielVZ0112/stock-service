package com.emazon.stockservice.infrastructure.output.jpa.repository;

import com.emazon.stockservice.infrastructure.output.jpa.entity.MarcaEntity;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@SuppressWarnings("all")
public interface iMarcaRepository extends JpaRepository<MarcaEntity, Long> {
    Optional<MarcaEntity> findByNombre(String nombre);
    @NonNull
    Page<MarcaEntity> findAll(Pageable pageable);
}
