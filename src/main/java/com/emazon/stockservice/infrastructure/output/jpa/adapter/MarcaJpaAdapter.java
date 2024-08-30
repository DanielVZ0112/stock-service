package com.emazon.stockservice.infrastructure.output.jpa.adapter;

import com.emazon.stockservice.domain.model.Marca;
import com.emazon.stockservice.domain.model.PaginatedResult;
import com.emazon.stockservice.domain.spi.iMarcaPersistencePort;
import com.emazon.stockservice.infrastructure.exception.marcaexception.MarcaDuplicateException;
import com.emazon.stockservice.infrastructure.exception.marcaexception.MarcaNotFoundException;
import com.emazon.stockservice.infrastructure.output.jpa.entity.MarcaEntity;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import com.emazon.stockservice.infrastructure.output.jpa.repository.iMarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class MarcaJpaAdapter implements iMarcaPersistencePort {

    private final iMarcaRepository marcaRepository;

    private final MarcaEntityMapper marcaEntityMapper;

    @Override
    public void createMarca(Marca marca) {
        if(marcaRepository.findByNombre(marca.getNombre()).isPresent()){
            throw new MarcaDuplicateException(marca.getNombre());
        }
        marcaRepository.save(marcaEntityMapper.toMarcaEntity(marca));
    }

    @Override
    public PaginatedResult<Marca> getAllMarca(int page, int size, String sortDirection) {
        Pageable pageable = PageRequest.of(page, size,
                sortDirection.equalsIgnoreCase("asc")
                        ? Sort.by("nombre").ascending()
                        : Sort.by("nombre").descending());
        Page<MarcaEntity> marcaEntities = marcaRepository.findAll(pageable);

        List<Marca> marcas = marcaEntities.stream()
                .map(marcaEntityMapper::toMarca)
                .toList();

        return new PaginatedResult<>(marcas, page, size);
    }

    @Override
    public Marca getMarca(Long id) {
        return marcaRepository.findById(id)
                .map(marcaEntityMapper::toMarca)
                .orElseThrow(MarcaNotFoundException::new);
    }

    @Override
    public void updateMarca(Marca marca) {
        MarcaEntity marcaEntity = marcaEntityMapper.toMarcaEntity(marca);
        marcaRepository.save(marcaEntity);
    }

    @Override
    public void deleteMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
