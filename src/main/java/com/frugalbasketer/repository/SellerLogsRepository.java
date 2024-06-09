package com.frugalbasketer.repository;

import com.frugalbasketer.entities.SellersLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SellerLogsRepository extends JpaRepository<SellersLogsEntity, Serializable> {
}
