package com.frugalbasketer.services;

import com.frugalbasketer.entities.OperatorsLogsEntity;

import java.util.List;

public interface OperatorLogsService {

    OperatorsLogsEntity saveOperatorLog(final OperatorsLogsEntity operatorsLogsEntity);

    List<OperatorsLogsEntity> getOperatorLogsByOperatorId(final int operatorId);
}
