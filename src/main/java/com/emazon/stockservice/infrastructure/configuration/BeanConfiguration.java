package com.emazon.stockservice.infrastructure.configuration;


import com.emazon.stockservice.domain.api.iCategoriaServicePort;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import com.emazon.stockservice.domain.useCase.CategoriaUseCase;
import com.emazon.stockservice.infrastructure.output.jpa.adapter.CategoriaJpaAdapter;
import com.emazon.stockservice.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.emazon.stockservice.infrastructure.output.jpa.repository.iCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final iCategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;

    @Bean
    public iCategoriaPersistencePort categoriaPersistencePort() {
        return new CategoriaJpaAdapter(categoriaRepository, categoriaEntityMapper);
    }
    @Bean
    public iCategoriaServicePort categoriaServicePort() {
        return new CategoriaUseCase(categoriaPersistencePort());
    }

}
