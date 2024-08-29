package com.emazon.stockservice.infrastructure.output.jpa.adapter;

import com.emazon.stockservice.domain.model.Marca;
import com.emazon.stockservice.domain.spi.iMarcaPersistencePort;
import com.emazon.stockservice.infrastructure.exception.marcaexception.MarcaDuplicateException;
import com.emazon.stockservice.infrastructure.exception.marcaexception.MarcaNotFoundException;
import com.emazon.stockservice.infrastructure.output.jpa.entity.MarcaEntity;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import com.emazon.stockservice.infrastructure.output.jpa.repository.iMarcaRepository;
import lombok.RequiredArgsConstructor;

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
    public List<Marca> getAllMarca() {
        List<MarcaEntity> marcaEntityList = marcaRepository.findAll();
        if(marcaEntityList.isEmpty()){
            throw new MarcaNotFoundException();
        }
        return marcaEntityMapper.toMarcaList(marcaEntityList);
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
