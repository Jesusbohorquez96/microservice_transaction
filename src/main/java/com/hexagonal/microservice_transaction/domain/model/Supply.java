package com.hexagonal.microservice_transaction.domain.model;

import java.time.LocalDateTime;

public class Supply {

    private Long id;
    private String name;
    private Integer quantity;
    private LocalDateTime supplyDate;
    private String status;
    private Long articleId;

    public Supply(Long id, String name, Integer quantity, LocalDateTime supplyDate, String status, Long articleId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.supplyDate = supplyDate;
        this.status = status;
        this.articleId = articleId;
    }

    public Supply() {
        this.supplyDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(LocalDateTime supplyDate) {
        this.supplyDate = supplyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", supplyDate=" + supplyDate +
                ", status='" + status + '\'' +
                ", articleId=" + articleId +
                '}';
    }
}
