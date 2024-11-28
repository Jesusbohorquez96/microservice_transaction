package com.hexagonal.microservice_transaction.domain.api;

import com.hexagonal.microservice_transaction.infrastructure.adapters.feign_client.ArticleClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class ArticleServiceTest {

    @Mock
    private ArticleClient articleClient;

    @InjectMocks
    private ArticleService articleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIncreaseArticleStock() {

        Long articleId = 1L;
        int quantity = 100;

        articleService.increaseArticleStock(articleId, quantity);

        verify(articleClient, times(1)).increaseStock(articleId, quantity);
    }
}