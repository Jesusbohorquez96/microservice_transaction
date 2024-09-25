package com.hexagonal.microservice_transaction.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class SupplyTest {

    private Supply supply;
    private Long id = 1L;
    private String name = "Supply Name";
    private Integer quantity = 100;
    private LocalDateTime supplyDate = LocalDateTime.now();
    private String status = "Available";
    private Long articleId = 2L;

    @BeforeEach
    public void setUp() {
        supply = new Supply(id, name, quantity, supplyDate, status, articleId);
    }

    @Test
    public void testGetters() {
        assertThat(supply.getId()).isEqualTo(id);
        assertThat(supply.getName()).isEqualTo(name);
        assertThat(supply.getQuantity()).isEqualTo(quantity);
        assertThat(supply.getSupplyDate()).isEqualTo(supplyDate);
        assertThat(supply.getStatus()).isEqualTo(status);
        assertThat(supply.getArticleId()).isEqualTo(articleId);
    }

    @Test
    public void testSetters() {
        Long newId = 2L;
        String newName = "New Supply Name";
        Integer newQuantity = 200;
        LocalDateTime newSupplyDate = LocalDateTime.now().plusDays(1);
        String newStatus = "Unavailable";
        Long newArticleId = 3L;

        supply.setId(newId);
        supply.setName(newName);
        supply.setQuantity(newQuantity);
        supply.setSupplyDate(newSupplyDate);
        supply.setStatus(newStatus);
        supply.setArticleId(newArticleId);

        assertThat(supply.getId()).isEqualTo(newId);
        assertThat(supply.getName()).isEqualTo(newName);
        assertThat(supply.getQuantity()).isEqualTo(newQuantity);
        assertThat(supply.getSupplyDate()).isEqualTo(newSupplyDate);
        assertThat(supply.getStatus()).isEqualTo(newStatus);
        assertThat(supply.getArticleId()).isEqualTo(newArticleId);
    }
}