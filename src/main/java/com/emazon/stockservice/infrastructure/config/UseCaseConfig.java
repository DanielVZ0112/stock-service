package com.emazon.stockservice.infrastructure.config;

import com.emazon.stockservice.domain.api.iCategoriaServicePort;
import com.emazon.stockservice.domain.spi.iCategoriaPersistencePort;
import com.emazon.stockservice.domain.useCase.CategoriaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    private final iCategoriaPersistencePort categoriaPersistencePort;

    public UseCaseConfig(iCategoriaPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }

    @Bean
    public iCategoriaServicePort categoriaServicePort() {
        return new CategoriaUseCase(categoriaPersistencePort);
    }
}
