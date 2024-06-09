package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.entities.AdminEntity;
import com.frugalbasketer.entities.AdminLogsEntity;
import com.frugalbasketer.repository.AdminLogsRepository;
import com.frugalbasketer.services.AdminLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class AdminLogsServiceImpl implements AdminLogsService {

    @Autowired
    private AdminLogsRepository adminLogsRepository;

    @Override
    public AdminLogsEntity saveAdminLog(AdminLogsEntity adminLogsEntity) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        var logTime = sdf.format(new Date());

        return adminLogsRepository.save(AdminLogsEntity.builder()
                .adminId(adminLogsEntity.getAdminId())
                .action(adminLogsEntity.getAction())
                .reason(adminLogsEntity.getReason())
                .log(adminLogsEntity.getLog())
                .logDateTime(logTime)
                .build());
    }

    @Override
    public List<AdminLogsEntity> getAdminLogsByAdminId(int adminId) {

        List<AdminLogsEntity> adminLogs = adminLogsRepository.findAllById(Collections.singleton(adminId));

        if(adminLogs.isEmpty()) {
            return null;
        }

       return adminLogs;
    }
}
