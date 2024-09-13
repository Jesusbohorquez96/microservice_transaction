package com.hexagonal.microservice_transaction.infrastructure.output.jpa.mapper;

import com.hexagonal.microservice_transaction.domain.model.Supply;
import com.hexagonal.microservice_transaction.infrastructure.output.jpa.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

@Mapper(componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyEntityMapper {

    SupplyEntity toEntity(Supply supply);
}
