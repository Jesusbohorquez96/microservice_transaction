package com.hexagonal.microservice_transaction.infrastructure.input.rest;

import com.hexagonal.microservice_transaction.application.dto.SupplyRequest;
import com.hexagonal.microservice_transaction.application.handler.SupplyHandler;
import com.hexagonal.microservice_transaction.domain.api.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SupplyRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SupplyHandler supplyHandler;

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private SupplyRestController supplyRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(supplyRestController).build();
    }

    @Test
    @WithMockUser(roles = {"admin", "aux_bodega"})
    public void saveSupplyIn_ShouldReturnOk() throws Exception {
        SupplyRequest supplyRequest = new SupplyRequest();
        supplyRequest.setArticleId(1L);
        supplyRequest.setQuantity(100);

        doNothing().when(supplyHandler).saveSupplyIn(supplyRequest);
        doNothing().when(articleService).increaseArticleStock(1L, 100);

        mockMvc.perform(put("/supplies/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"articleId\":1,\"quantity\":100}"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"admin", "aux_bodega"})
    public void saveSupplyIn_ShouldReturnInternalServerError_WhenExceptionOccurs() throws Exception {

        SupplyRequest supplyRequest = new SupplyRequest();
        supplyRequest.setArticleId(1L);
        supplyRequest.setQuantity(100);

        doThrow(new RuntimeException()).when(supplyHandler).saveSupplyIn(supplyRequest);

        mockMvc.perform(put("/supplies/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"articleId\":1,\"quantity\":100}"))
                .andExpect(status().isInternalServerError());
    }
}