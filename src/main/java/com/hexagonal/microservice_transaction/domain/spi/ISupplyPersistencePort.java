package com.hexagonal.microservice_transaction.domain.spi;

import com.hexagonal.microservice_transaction.domain.model.Supply;

public interface ISupplyPersistencePort {

    void saveSupply(Supply supply);

}
