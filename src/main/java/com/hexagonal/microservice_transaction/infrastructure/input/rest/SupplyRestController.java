package com.hexagonal.microservice_transaction.infrastructure.input.rest;

import com.hexagonal.microservice_transaction.application.dto.SupplyRequest;
import com.hexagonal.microservice_transaction.application.handler.SupplyHandler;
import com.hexagonal.microservice_transaction.domain.api.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

@RestController
@RequestMapping(SUPPLIES_URL)
@RequiredArgsConstructor
public class SupplyRestController {

    private final SupplyHandler supplyHandler;
    private final ArticleService articleService;

    @PutMapping()
    @PreAuthorize(ROL_ADMIN_AUX)
    public ResponseEntity<?> saveSupplyIn(@RequestBody SupplyRequest supplyRequest) {
        try {
            supplyHandler.saveSupplyIn(supplyRequest);
            articleService.increaseArticleStock(supplyRequest.getArticleId(), supplyRequest.getQuantity());
            return ResponseEntity.ok(Collections.singletonMap(MESSAGE, SUPPLY_SUCCESSFULLY));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap(MESSAGE, ARTICLE_NOT_FOUND));
        }
    }
}