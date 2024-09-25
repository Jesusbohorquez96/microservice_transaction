package com.hexagonal.microservice_transaction.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

@Entity
@Table(name = SUPPLY)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

    @Column(name = STATUS, length = STATUS_LENGTH, nullable = false)
    private String status;

    @Column(nullable = false)
    private Long articleId;

    @PrePersist
    protected void onCreate() {
        this.supplyDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.supplyDate = LocalDateTime.now();
    }
}

