package com.hexagonal.microservice_transaction.infrastructure.adapters.interceptor;

import com.hexagonal.microservice_transaction.infrastructure.adapters.jwtconfiguration.JwtService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.AUTHORIZATION;
import static com.hexagonal.microservice_transaction.constants.ValidationConstants.BEARER;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private final JwtService jwtService;

    public FeignClientInterceptor(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = jwtService.obtainTokenJWT();
        requestTemplate.header(AUTHORIZATION, BEARER + token);
    }
}
