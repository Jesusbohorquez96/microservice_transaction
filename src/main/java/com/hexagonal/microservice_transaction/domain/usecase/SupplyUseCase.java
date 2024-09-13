package com.hexagonal.microservice_transaction.domain.usecase;

import com.hexagonal.microservice_transaction.domain.api.ISupplyServicePort;
import com.hexagonal.microservice_transaction.domain.model.Supply;
import com.hexagonal.microservice_transaction.domain.spi.ISupplyPersistencePort;

public abstract class SupplyUseCase implements ISupplyServicePort {

    private final ISupplyPersistencePort supplyPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
    }

    @Override
    public void saveSupply(Supply supply) {
        supplyPersistencePort.saveSupply(supply);
    }
}
