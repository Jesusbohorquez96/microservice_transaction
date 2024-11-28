package com.hexagonal.microservice_transaction.infrastructure.adapters.interceptor;

import com.hexagonal.microservice_transaction.infrastructure.adapters.jwtconfiguration.JwtService;
import feign.RequestTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.AUTHORIZATION;
import static com.hexagonal.microservice_transaction.constants.ValidationConstants.BEARER;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FeignClientInterceptorTest {

    @Mock
    private JwtService jwtService;

    @Mock
    private RequestTemplate requestTemplate;

    @InjectMocks
    private FeignClientInterceptor feignClientInterceptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void apply_ShouldAddAuthorizationHeader_WhenTokenIsProvided() {

        String token = "test_token";
        when(jwtService.obtainTokenJWT()).thenReturn(token);

        feignClientInterceptor.apply(requestTemplate);

        verify(requestTemplate).header(AUTHORIZATION, BEARER + token);
    }
}