package com.hexagonal.microservice_transaction.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SupplyRequest {

    private String name;

    private int quantity;

    private String status;

}
