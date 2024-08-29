package com.emazon.stockservice.application.handler;

import com.emazon.stockservice.application.dto.MarcaDTORequest;
import com.emazon.stockservice.application.dto.MarcaDTOResponse;
import com.emazon.stockservice.application.mapper.MarcaDTOMapperRequest;
import com.emazon.stockservice.application.mapper.MarcaDTOMapperResponse;
import com.emazon.stockservice.domain.api.iMarcaServicePort;
import com.emazon.stockservice.domain.model.Marca;
import com.emazon.stockservice.infrastructure.exception.categoriaexception.CategoriaNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MarcaHandler implements iMarcaHandler {

    private final iMarcaServicePort marcaServicePort;
    private final MarcaDTOMapperRequest marcaDTOMapperRequest;
    private final MarcaDTOMapperResponse marcaDTOMapperResponse;

    @Override
    public void createMarcaInStockService(MarcaDTORequest marcaDTORequest) {
        Marca marca = marcaDTOMapperRequest.toMarca(marcaDTORequest);
        marcaServicePort.createMarca(marca);
    }

    @Override
    public List<MarcaDTOResponse> getAllMarcaFromStockService() {
        return marcaDTOMapperResponse.toMarcaDTOResponseList(marcaServicePort.getAllMarca());
    }

    @Override
    public MarcaDTOResponse getMarcaFromStockService(Long id) {
        Marca marca = marcaServicePort.getMarca(id);
        return marcaDTOMapperResponse.toMarcaDTOResponse(marca);
    }

    @Override
    public void updateMarcaInStockService(MarcaDTORequest marcaDTORequest) {
        if (marcaDTORequest.getId() == null) {
            throw new CategoriaNotFoundException();
        }

        Marca marcaExit = marcaServicePort.getMarca(marcaDTORequest.getId());
        if (marcaExit == null) {
            throw new CategoriaNotFoundException();
        }

        Marca newMarca = marcaDTOMapperRequest.toMarca(marcaDTORequest);
        newMarca.setId(marcaExit.getId());
        marcaServicePort.updateMarca(newMarca);
    }

    @Override
    public void deleteMarcaFromStockService(Long id) {
        marcaServicePort.deleteMarca(id);
    }
}
