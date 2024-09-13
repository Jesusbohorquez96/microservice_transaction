package com.hexagonal.microservice_transaction.infrastructure.output.jpa.adapter;

import com.hexagonal.microservice_transaction.domain.model.Supply;
import com.hexagonal.microservice_transaction.domain.spi.ISupplyPersistencePort;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.mapper.SupplyEntityMapper;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyJpaAdapter implements ISupplyPersistencePort {

    private final ISupplyRepository supplyRepository;

    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    public void saveSupply(Supply supply) {
        supplyRepository.save(supplyEntityMapper.toEntity(supply));
    }
}
