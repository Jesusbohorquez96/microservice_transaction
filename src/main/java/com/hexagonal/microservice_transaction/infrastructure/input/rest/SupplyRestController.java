package com.hexagonal.microservice_transaction.infrastructure.input.rest;

import com.hexagonal.microservice_transaction.application.dto.SupplyRequest;
import com.hexagonal.microservice_transaction.application.handler.SupplyHandler;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

@RestController
@RequestMapping(SUPPLIES_URL)
@RequiredArgsConstructor
public class SupplyRestController {

    private final SupplyHandler supplyHandler;

    @Operation(summary = CREATE_SUPPLY_DESCRIPTION, description = CREATE_SUPPLY_ACTION)
    @PostMapping(BASE_URL)
    public ResponseEntity<Void> saveSupplyIn(@Valid @RequestBody SupplyRequest supplyRequest) {
        supplyHandler.saveSupplyIn(supplyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
