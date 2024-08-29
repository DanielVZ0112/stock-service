package com.emazon.stockservice.infrastructure.configuration;


import com.emazon.stockservice.domain.api.iCategoriaServicePort;
import com.emazon.stockservice.domain.api.iMarcaServicePort;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import com.emazon.stockservice.domain.spi.iMarcaPersistencePort;
import com.emazon.stockservice.domain.usecase.CategoriaUseCase;
import com.emazon.stockservice.domain.usecase.MarcaUseCase;
import com.emazon.stockservice.infrastructure.output.jpa.adapter.CategoriaJpaAdapter;
import com.emazon.stockservice.infrastructure.output.jpa.adapter.MarcaJpaAdapter;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import com.emazon.stockservice.infrastructure.output.jpa.repository.iCategoriaRepository;
import com.emazon.stockservice.infrastructure.output.jpa.repository.iMarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final iCategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;
    private final iMarcaRepository marcaRepository;
    private final MarcaEntityMapper marcaEntityMapper;

    @Bean
    public iCategoriaPersistencePort categoriaPersistencePort() {
        return new CategoriaJpaAdapter(categoriaRepository, categoriaEntityMapper);
    }
    @Bean
    public iCategoriaServicePort categoriaServicePort() {
        return new CategoriaUseCase(categoriaPersistencePort());
    }
    @Bean
    public iMarcaPersistencePort marcaPersistencePort() {
        return new MarcaJpaAdapter(marcaRepository, marcaEntityMapper);
    }
    @Bean
    public iMarcaServicePort marcaServicePort() {
        return new MarcaUseCase(marcaPersistencePort());
    }
}
