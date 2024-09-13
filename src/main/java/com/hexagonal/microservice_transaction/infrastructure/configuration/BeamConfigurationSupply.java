package com.hexagonal.microservice_transaction.infrastructure.configuration;

import com.hexagonal.microservice_transaction.domain.api.ISupplyServicePort;
import com.hexagonal.microservice_transaction.domain.spi.ISupplyPersistencePort;
import com.hexagonal.microservice_transaction.domain.usecase.SupplyUseCase;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.adapter.SupplyJpaAdapter;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.mapper.SupplyEntityMapper;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeamConfigurationSupply {

    private final ISupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(supplyPersistencePort()) {
        };
    }
}

