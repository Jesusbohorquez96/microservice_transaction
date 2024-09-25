package com.hexagonal.microservice_transaction.domain.usecase;

import com.hexagonal.microservice_transaction.domain.api.ISupplyServicePort;
import com.hexagonal.microservice_transaction.domain.model.Supply;
import com.hexagonal.microservice_transaction.domain.spi.ISupplyPersistencePort;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

public class SupplyUseCase implements ISupplyServicePort {

    private final ISupplyPersistencePort supplyPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
    }

    @Override
    public void saveSupply(Supply supply) {
        if (supply.getId() == null) {
            throw new IllegalArgumentException(ARTICLE_ID_NOT_NULL);
        }
        supplyPersistencePort.saveSupply(supply);
    }
}
