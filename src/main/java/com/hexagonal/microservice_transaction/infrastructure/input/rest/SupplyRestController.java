package com.hexagonal.microservice_transaction.infrastructure.input.rest;

import com.hexagonal.microservice_transaction.application.dto.SupplyRequest;
import com.hexagonal.microservice_transaction.application.handler.SupplyHandler;
import com.hexagonal.microservice_transaction.domain.api.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

@RestController
@RequestMapping(SUPPLIES_URL)
@RequiredArgsConstructor
public class SupplyRestController {

    private final SupplyHandler supplyHandler;
    private final ArticleService articleService;

    @PutMapping(BASE_URL)
    @PreAuthorize("hasAnyRole('admin', 'aux_bodega')")
    public ResponseEntity<Void> saveSupplyIn(@RequestBody SupplyRequest supplyRequest) {
        try {
            supplyHandler.saveSupplyIn(supplyRequest);
            articleService.increaseArticleStock(supplyRequest.getArticleId(), supplyRequest.getQuantity());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            //todo este es el error que se muestra en el log
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }
    }
}