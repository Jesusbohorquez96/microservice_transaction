package com.hexagonal.microservice_transaction.infrastructure.output.jpa.repository;

import com.hexagonal.microservice_transaction.infrastructure.output.jpa.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {

    Optional<SupplyEntity> findById(Long supplyId);
}
