package com.hexagonal.microservice_transaction.application.handler;

import com.hexagonal.microservice_transaction.application.dto.SupplyRequest;
import com.hexagonal.microservice_transaction.application.mapper.SupplyRequestMapper;
import com.hexagonal.microservice_transaction.domain.api.ISupplyServicePort;
import com.hexagonal.microservice_transaction.domain.model.Supply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SupplyHandlerTest {

    @Mock
    private SupplyRequestMapper supplyRequestMapper;

    @Mock
    private ISupplyServicePort supplyServicePort;

    @InjectMocks
    private SupplyHandler supplyHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSupplyIn_ShouldMapRequestAndSaveSupply() {

        SupplyRequest supplyRequest = new SupplyRequest();
        Supply supply = new Supply(1L, "Test Supply", 100, null, "Available", 2L);

        when(supplyRequestMapper.toSupply(any(SupplyRequest.class))).thenReturn(supply);

        supplyHandler.saveSupplyIn(supplyRequest);

        verify(supplyRequestMapper).toSupply(supplyRequest);
        verify(supplyServicePort).saveSupply(supply);
    }
}