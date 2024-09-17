package com.hexagonal.microservice_transaction.infrastructure.adapters.feign_client;

import com.hexagonal.microservice_transaction.application.dto.SupplyResponse;
import com.hexagonal.microservice_transaction.infrastructure.configuration.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "emazon-hexagonal", url = "http://localhost:8080/articles", name = "emazon-hexagonal", configuration = FeignConfig.class)
public interface ArticleClient {

    @PutMapping(value = "/increase-stock/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void increaseStock(@PathVariable("articleId") Long articleId, @RequestParam("additionalStock") int additionalStock);

    @GetMapping(value = "/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    SupplyResponse getArticleById(@PathVariable("articleId") Long articleId);
}
