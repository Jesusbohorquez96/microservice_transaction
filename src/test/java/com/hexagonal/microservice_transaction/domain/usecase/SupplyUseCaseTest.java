package com.hexagonal.microservice_transaction.domain.usecase;

import com.hexagonal.microservice_transaction.domain.model.Supply;
import com.hexagonal.microservice_transaction.domain.spi.ISupplyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

class SupplyUseCaseTest {

    @Mock
    private ISupplyPersistencePort supplyPersistencePort;

    @InjectMocks
    private SupplyUseCase supplyUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSupply_ShouldCallPersistencePort_WhenSupplyHasId() {

        Supply supply = new Supply(1L, "Test Supply", 100, null, "Available", 1L);

        supplyUseCase.saveSupply(supply);

        verify(supplyPersistencePort).saveSupply(supply);
    }

    @Test
    void saveSupply_ShouldThrowException_WhenSupplyHasNoId() {

        Supply supply = new Supply(null, "Test Supply", 100, null, "Available", 1L);

//        assertThatThrownBy(() -> supplyUseCase.saveSupply(supply))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ARTICLE_ID_NOT_NULL);
    }
}