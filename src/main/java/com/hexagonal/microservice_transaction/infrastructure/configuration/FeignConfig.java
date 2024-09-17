package com.hexagonal.microservice_transaction.infrastructure.configuration;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String token = "Bearer " + obtenerTokenJWT();
            requestTemplate.header("Authorization", token);
        };
    }

    private String obtenerTokenJWT() {
        return "tu_token_jwt";
    }
}