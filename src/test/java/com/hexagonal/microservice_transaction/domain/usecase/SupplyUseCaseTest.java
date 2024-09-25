package com.hexagonal.microservice_transaction.domain.usecase;

import com.hexagonal.microservice_transaction.domain.model.Supply;
import com.hexagonal.microservice_transaction.domain.spi.ISupplyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class SupplyUseCaseTest {

    private ISupplyPersistencePort supplyPersistencePort;
    private SupplyUseCase supplyUseCase;

    @BeforeEach
    public void setUp() {
        supplyPersistencePort = Mockito.mock(ISupplyPersistencePort.class);
        supplyUseCase = new SupplyUseCaseImpl(supplyPersistencePort);
    }

    @Test
    public void testSaveSupply() {
        Supply supply = new Supply(1L, "Test Supply", 100, LocalDateTime.now(), "Available", 2L);

        supplyUseCase.saveSupply(supply);

        verify(supplyPersistencePort, times(1)).saveSupply(supply);
    }

    public static class SupplyUseCaseImpl extends SupplyUseCase {
        public SupplyUseCaseImpl(ISupplyPersistencePort supplyPersistencePort) {
            super(supplyPersistencePort);
        }
    }
}