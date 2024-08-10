package com.frugalbasketer.repository;

import com.frugalbasketer.entities.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface OperatorRepository extends JpaRepository<OperatorEntity, Serializable> {

    OperatorEntity findByEmail(String email);
    List<OperatorEntity> findAllByOperatorStatus(String operatorStatus);
    long countByOperatorStatus(String operatorStatus);
}
