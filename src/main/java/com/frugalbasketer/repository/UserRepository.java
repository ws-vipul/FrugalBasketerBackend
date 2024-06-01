package com.frugalbasketer.repository;

import com.frugalbasketer.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

    UserEntity findByEmail(String email);
}
