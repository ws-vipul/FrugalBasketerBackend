package com.frugalbasketer.repository;

import com.frugalbasketer.entities.OperatorsLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface OperatorLogsRepository extends JpaRepository<OperatorsLogsEntity, Serializable> {
}
