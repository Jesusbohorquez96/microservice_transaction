package com.hexagonal.microservice_transaction.application.mapper;

import com.hexagonal.microservice_transaction.application.dto.SupplyRequest;
import com.hexagonal.microservice_transaction.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

@Mapper(componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyRequestMapper {

    Supply toSupply(SupplyRequest supplyRequest);
}
