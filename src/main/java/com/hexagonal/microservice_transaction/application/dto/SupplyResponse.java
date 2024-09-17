package com.hexagonal.microservice_transaction.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class SupplyResponse {

    private Long supplyId;

    private String supplyName;

    private int supplyQuantity;

    private LocalDateTime supplyDate;

    private String supplyStatus;

    private int stock;

}
