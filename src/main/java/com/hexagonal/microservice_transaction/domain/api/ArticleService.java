package com.hexagonal.microservice_transaction.domain.api;

import com.hexagonal.microservice_transaction.infrastructure.adapters.feign_client.ArticleClient;
import org.springframework.stereotype.Service;

@Service
public class ArticleService  {

    private final ArticleClient articleClient;

    public ArticleService(ArticleClient articleClient) {
        this.articleClient = articleClient;
    }

    public void increaseArticleStock(Long articleId, int quantity) {
        articleClient.increaseStock(articleId, quantity);

    }
}