package com.hexagonal.microservice_transaction.infrastructure.output.jpa.adapter;

import com.hexagonal.microservice_transaction.domain.model.Supply;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.entity.SupplyEntity;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.mapper.SupplyEntityMapper;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.repository.ISupplyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SupplyJpaAdapterTest {

    @Mock
    private ISupplyRepository supplyRepository;

    @Mock
    private SupplyEntityMapper supplyEntityMapper;

    @InjectMocks
    private SupplyJpaAdapter supplyJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSupply_ShouldMapToEntityAndSave() {

        Supply supply = new Supply(1L, "Test Supply", 100, null, "Available", 2L);
        SupplyEntity supplyEntity = new SupplyEntity(1L, "Test Supply", 100, null, "Available", 2L);

        when(supplyEntityMapper.toEntity(any(Supply.class))).thenReturn(supplyEntity);

        supplyJpaAdapter.saveSupply(supply);

        verify(supplyEntityMapper).toEntity(supply);
        verify(supplyRepository).save(supplyEntity);
    }
}