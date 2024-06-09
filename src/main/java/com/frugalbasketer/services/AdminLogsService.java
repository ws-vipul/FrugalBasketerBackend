package com.frugalbasketer.services;

import com.frugalbasketer.entities.AdminLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface AdminLogsService {

    AdminLogsEntity saveAdminLog(final AdminLogsEntity adminLogsEntity);

    List<AdminLogsEntity> getAdminLogsByAdminId(final int adminId);


}
