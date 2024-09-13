package com.hexagonal.microservice_transaction.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

@Entity
@Table(name = SUPPLY)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = NAME, length = NAME_LENGTH, nullable = false)
    private String name;

    @Column(name = QUANTITY, nullable = false)
    private int quantity;

    @Column(name = SUPPLY_DATE, nullable = false)
    private LocalDateTime supplyDate;

    @Column(name = LAST_UPDATED, nullable = false)
    private LocalDateTime lastUpdated;

    @Column(name = STATUS, length = STATUS_LENGTH, nullable = false)
    private String status;

    @PrePersist
    protected void onCreate() {
        this.supplyDate = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdated = LocalDateTime.now();
    }
}

