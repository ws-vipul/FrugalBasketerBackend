package com.frugalbasketer.repository;

import com.frugalbasketer.entities.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Serializable> {


}
