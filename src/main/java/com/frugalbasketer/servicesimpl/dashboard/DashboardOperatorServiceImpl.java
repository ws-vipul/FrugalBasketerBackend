package com.frugalbasketer.servicesimpl.dashboard;

import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.AdminLogsEntity;
import com.frugalbasketer.entities.OperatorEntity;
import com.frugalbasketer.entities.OperatorsLogsEntity;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteOperatorRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.AdminLogsService;
import com.frugalbasketer.services.OperatorLogsService;
import com.frugalbasketer.services.OperatorsService;
import com.frugalbasketer.services.dashboard.DashboardOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardOperatorServiceImpl implements DashboardOperatorService {

    @Autowired
    private OperatorsService operatorsService;
    @Autowired
    private OperatorLogsService operatorLogsService;
    @Autowired
    private AdminLogsService adminLogsService;

    @Override
    public ResponseModel deleteOperator(DashDeleteOperatorRequestModel dashDeleteOperatorRequestModel) {
        OperatorEntity deletedOperator = operatorsService.deleteOperator(dashDeleteOperatorRequestModel.getOperatorId());
        if (deletedOperator != null) {
            adminLogsService.saveAdminLog(AdminLogsEntity.builder()
                    .adminId(dashDeleteOperatorRequestModel.getAdminId())
                    .log("deleted operator with operatorId : " + dashDeleteOperatorRequestModel.getOperatorId())
                    .reason(dashDeleteOperatorRequestModel.getReason())
                    .action(StringConstants.DELETED)
                    .build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .message("Operator deleted Successful").build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("Technical Error in Deleting Operator")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchAllOperator() {
        List<OperatorEntity> operatorEntityList = operatorsService.getAllOperators();
        if(!operatorEntityList.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(operatorEntityList)
                    .build();
        } else  {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Operator Found")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchOperatorDetailsById(int operatorId) {
        OperatorEntity operatorEntity = operatorsService.getOperatorDetails(operatorId);
        if (operatorEntity != null) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(operatorEntity)
                    .build();
        }  else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Operator Details Found")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchOperatorActivityLogs(int operatorId) {
        List<OperatorsLogsEntity> operatorsLogsEntityList = operatorLogsService.getOperatorLogsByOperatorId(operatorId);
        if(!operatorsLogsEntityList.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(operatorsLogsEntityList)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Operators Activity Logs Found")
                    .build();
        }
    }
}
