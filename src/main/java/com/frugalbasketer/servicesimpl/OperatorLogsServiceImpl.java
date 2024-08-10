package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.entities.OperatorsLogsEntity;
import com.frugalbasketer.repository.OperatorLogsRepository;
import com.frugalbasketer.services.OperatorLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OperatorLogsServiceImpl implements OperatorLogsService {

    @Autowired
    OperatorLogsRepository operatorLogsRepository;
    @Override
    public OperatorsLogsEntity saveOperatorLog(OperatorsLogsEntity operatorsLogsEntity) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        var logTime = sdf.format(new Date());

        return operatorLogsRepository.save(OperatorsLogsEntity.builder()
                .operatorId(operatorsLogsEntity.getOperatorId())
                .action(operatorsLogsEntity.getAction())
                .log(operatorsLogsEntity.getLog())
                .reason(operatorsLogsEntity.getReason())
                .logDateTime(logTime)
                .build());
    }

    @Override
    public List<OperatorsLogsEntity> getOperatorLogsByOperatorId(int operatorId) {
        List<OperatorsLogsEntity> operatorLogs = operatorLogsRepository.findAllById(Collections.singleton(operatorId));

        if(operatorLogs.isEmpty()) {
            return null;
        }

        return operatorLogs;
    }
}
