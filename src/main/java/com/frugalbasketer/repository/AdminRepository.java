package com.frugalbasketer.repository;

import com.frugalbasketer.entities.AdminEntity;
import com.frugalbasketer.entities.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Serializable> {
    AdminEntity findByEmail(String email);
    List<AdminEntity> findAllByAdminStatus(String adminStatus);
    List<AdminEntity> findAllByFirstNameContains(String firstName);
    List<AdminEntity> findAllByLastNameContains(String lastName);
    List<AdminEntity> findAllByMobNumContains(String mobileNum);
    List<AdminEntity> findAllByEmailContains(String email);
    long countByAdminStatus(String adminStatus);
}
