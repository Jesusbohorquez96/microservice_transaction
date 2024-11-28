package com.hexagonal.microservice_transaction.infrastructure.output.jpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class SupplyEntityTest {

    private SupplyEntity supplyEntity;

    @BeforeEach
    void setUp() {
        supplyEntity = new SupplyEntity();
        supplyEntity.setId(1L);
        supplyEntity.setName("Test Supply");
        supplyEntity.setQuantity(100);
        supplyEntity.setStatus("Available");
        supplyEntity.setArticleId(2L);
    }

    @Test
    void testPrePersist_ShouldSetSupplyDateOnCreate() {
        supplyEntity.onCreate();

        assertThat(supplyEntity.getSupplyDate()).isNotNull();
        assertThat(supplyEntity.getSupplyDate()).isBeforeOrEqualTo(LocalDateTime.now());
    }

    @Test
    void testPreUpdate_ShouldUpdateSupplyDateOnUpdate() {
        LocalDateTime initialDate = LocalDateTime.of(2023, 1, 1, 12, 0);
        supplyEntity.setSupplyDate(initialDate);

        supplyEntity.onUpdate();

        assertThat(supplyEntity.getSupplyDate()).isNotNull();
        assertThat(supplyEntity.getSupplyDate()).isAfter(initialDate);
    }
}