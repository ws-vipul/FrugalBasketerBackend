package com.frugalbasketer.repository;

import com.frugalbasketer.entities.UserLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UsersLogsRepository extends JpaRepository<UserLogsEntity, Serializable> {

}
