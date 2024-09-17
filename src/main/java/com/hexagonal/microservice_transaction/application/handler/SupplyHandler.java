package com.hexagonal.microservice_transaction.application.handler;

import com.hexagonal.microservice_transaction.application.dto.SupplyRequest;
import com.hexagonal.microservice_transaction.application.mapper.SupplyRequestMapper;
import com.hexagonal.microservice_transaction.domain.api.ISupplyServicePort;
import com.hexagonal.microservice_transaction.domain.model.Supply;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplyHandler implements ISupplyHandler {

    private final SupplyRequestMapper supplyRequestMapper;
    private final ISupplyServicePort supplyServicePort;

    @Override
    public void saveSupplyIn(SupplyRequest supplyRequest) {
        System.out.println("camfoesa " + supplyRequest);
        Supply supply = supplyRequestMapper.toSupply(supplyRequest);
        System.out.println("fjesusf " + supply);
        supplyServicePort.saveSupply(supply);
        System.out.println("karen " + supply);
    }
}
