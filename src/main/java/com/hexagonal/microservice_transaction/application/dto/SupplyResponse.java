package com.hexagonal.microservice_transaction.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SupplyResponse {

    private Long supplyId;

    private String supplyName;

    private int supplyQuantity;

    private LocalDateTime supplyDate;

    private LocalDateTime supplyLastUpdated;

    private String supplyStatus;

}
