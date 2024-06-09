package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.entities.SellersLogsEntity;
import com.frugalbasketer.entities.UserLogsEntity;
import com.frugalbasketer.repository.UsersLogsRepository;
import com.frugalbasketer.services.UserLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class UserLogsServiceImpl implements UserLogsService {

    @Autowired
    UsersLogsRepository usersLogsRepository;
    @Override
    public UserLogsEntity saveUserLog(UserLogsEntity userLogsEntity) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        var logTime = sdf.format(new Date());

        return usersLogsRepository.save(UserLogsEntity.builder()
                .userId(userLogsEntity.getUserId())
                .action(userLogsEntity.getAction())
                .log(userLogsEntity.getLog())
                .reason(userLogsEntity.getReason())
                .logDateTime(logTime)
                .build());
    }

    @Override
    public List<UserLogsEntity> getUserLogsByUserId(int userId) {
        List<UserLogsEntity> userLogs = usersLogsRepository.findAllById(Collections.singleton(userId));
        if(userLogs.isEmpty()) {
            return null;
        }
        return userLogs;
    }
}
