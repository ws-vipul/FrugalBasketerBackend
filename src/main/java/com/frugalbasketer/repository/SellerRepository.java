package com.frugalbasketer.repository;

import com.frugalbasketer.entities.SellerEntity;
import com.frugalbasketer.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Serializable> {

    SellerEntity findByEmail(String email);
    List<SellerEntity> findAllBySellerStatus(String sellerStatus);
    long countBySellerStatus(String sellerStatus);
}
