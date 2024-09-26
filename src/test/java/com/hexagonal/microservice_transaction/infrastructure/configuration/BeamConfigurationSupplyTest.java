package com.hexagonal.microservice_transaction.infrastructure.configuration;

import com.hexagonal.microservice_transaction.domain.api.ISupplyServicePort;
import com.hexagonal.microservice_transaction.domain.spi.ISupplyPersistencePort;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.adapter.SupplyJpaAdapter;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.mapper.SupplyEntityMapper;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.repository.ISupplyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class BeamConfigurationSupplyTest {

    @Mock
    private ISupplyRepository supplyRepository;

    @Mock
    private SupplyEntityMapper supplyEntityMapper;

    @InjectMocks
    private BeamConfigurationSupply beamConfigurationSupply;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void supplyPersistencePort_ShouldReturnSupplyJpaAdapter() {

        ISupplyPersistencePort supplyPersistencePort = beamConfigurationSupply.supplyPersistencePort();

        assertThat(supplyPersistencePort).isInstanceOf(SupplyJpaAdapter.class);
    }

    @Test
    void supplyServicePort_ShouldReturnSupplyUseCase() {

        ISupplyServicePort supplyServicePort = beamConfigurationSupply.supplyServicePort();

        assertThat(supplyServicePort).isNotNull();
    }

    @Test
    void restTemplate_ShouldReturnRestTemplateInstance() {

        RestTemplate restTemplate = beamConfigurationSupply.restTemplate();

        assertThat(restTemplate).isNotNull();
    }
}