package com.frugalbasketer.repository;

import com.frugalbasketer.entities.AdminEntity;
import com.frugalbasketer.entities.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Serializable> {
    AdminEntity findByEmail(String email);
    List<AdminEntity> findAllByAdminStatus(String adminStatus);
    long countByAdminStatus(String adminStatus);
}
