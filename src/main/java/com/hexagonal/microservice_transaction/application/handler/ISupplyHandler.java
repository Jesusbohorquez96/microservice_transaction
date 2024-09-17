package com.hexagonal.microservice_transaction.application.handler;

import com.hexagonal.microservice_transaction.application.dto.SupplyRequest;

public interface ISupplyHandler {

    void saveSupplyIn(SupplyRequest supplyRequest);

}
 