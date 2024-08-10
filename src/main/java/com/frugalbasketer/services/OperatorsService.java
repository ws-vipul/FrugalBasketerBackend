package com.frugalbasketer.services;

import com.frugalbasketer.entities.OperatorEntity;
import com.frugalbasketer.model.requestmodel.dashboard.DashOperatorRegistrationRequestModel;

import java.util.List;

public interface OperatorsService {

    OperatorEntity getOperatorDetails(int operatorId);
    OperatorEntity createOperator(DashOperatorRegistrationRequestModel dashOperatorRegistrationRequestModel);
    List<OperatorEntity> getAllOperators();
    OperatorEntity deleteOperator(int operatorId);
    List<OperatorEntity> getAllActiveOperator();
    String getCountOfActiveOperator();
    OperatorEntity updateOperator(OperatorEntity operatorEntity);
}
