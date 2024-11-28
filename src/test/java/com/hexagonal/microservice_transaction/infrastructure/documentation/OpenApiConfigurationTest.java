package com.hexagonal.microservice_transaction.infrastructure.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class OpenApiConfigurationTest {

    @InjectMocks
    private OpenApiConfiguration openApiConfiguration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void customOpenApi_ShouldReturnCorrectOpenAPI() {

        String appDescription = "Test App Description";
        String appVersion = "1.0.0";

        OpenAPI openAPI = openApiConfiguration.customOpenApi(appDescription, appVersion);

        assertThat(openAPI.getInfo()).isNotNull();
        Info info = openAPI.getInfo();

        assertThat(info.getTitle()).isEqualTo(TITLE);
        assertThat(info.getVersion()).isEqualTo(appVersion);
        assertThat(info.getDescription()).isEqualTo(appDescription);
        assertThat(info.getTermsOfService()).isEqualTo(TERMS_OF_SERVICE_URL);
        License license = info.getLicense();
        assertThat(license.getName()).isEqualTo(LICENSE_NAME);
        assertThat(license.getUrl()).isEqualTo(LICENSE_URL);
    }
}