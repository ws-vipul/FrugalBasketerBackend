package com.frugalbasketer.servicesimpl.web;

import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.OperatorEntity;
import com.frugalbasketer.entities.OperatorsLogsEntity;
import com.frugalbasketer.model.requestmodel.dashboard.DashOperatorRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.OperatorLogsService;
import com.frugalbasketer.services.OperatorsService;
import com.frugalbasketer.services.web.WebOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebOperatorServiceImpl implements WebOperatorService {

    @Autowired
    private OperatorsService operatorsService;
    @Autowired
    private OperatorLogsService operatorLogsService;

    @Override
    public ResponseModel registerOperator(DashOperatorRegistrationRequestModel dashOperatorRegistrationRequestModel) {
        OperatorEntity operatorEntity= operatorsService.createOperator(dashOperatorRegistrationRequestModel);

        if(operatorEntity != null) {

            operatorLogsService.saveOperatorLog(OperatorsLogsEntity.builder()
                    .operatorId(operatorEntity.getId())
                    .action(StringConstants.CREATED)
                    .reason(StringConstants.NA)
                    .log("created account")
                    .build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(operatorEntity)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("There is already an account with this email Id")
                    .build();
        }
    }
}
