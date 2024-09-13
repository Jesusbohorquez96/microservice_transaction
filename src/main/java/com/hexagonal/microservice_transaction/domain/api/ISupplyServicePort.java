package com.hexagonal.microservice_transaction.domain.api;

import com.hexagonal.microservice_transaction.domain.model.Supply;

public interface ISupplyServicePort {

    void saveSupply(Supply supply);
}
