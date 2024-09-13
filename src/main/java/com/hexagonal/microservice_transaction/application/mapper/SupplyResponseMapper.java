package com.hexagonal.microservice_transaction.application.mapper;

import com.hexagonal.microservice_transaction.application.dto.SupplyResponse;
import com.hexagonal.microservice_transaction.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

@Mapper(componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyResponseMapper {

    @Mapping(target = SUPPLY_ID, source = ID)
    @Mapping(target = SUPPLY_NAME, source = NAME)
    @Mapping(target = SUPPLY_QUANTITY, source = QUANTITY)
    @Mapping(target = TARGET_SUPPLY_DATE, source = SUPPLY_DATE)
    @Mapping(target = SUPPLY_LAST_UPDATED, source = LAST_UPDATED)
    @Mapping(target = SUPPLY_STATUS, source = STATUS)

    SupplyResponse toSupplyResponse(Supply entity);
}
