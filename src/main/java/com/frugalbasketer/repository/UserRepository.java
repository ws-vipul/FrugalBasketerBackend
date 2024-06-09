package com.frugalbasketer.repository;

import com.frugalbasketer.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

    UserEntity findByEmail(String email);
    List<UserEntity> findAllByUserStatus(String userStatus);
    long countByUserStatus(String userStatus);
}
