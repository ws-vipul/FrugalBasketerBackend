package com.frugalbasketer.services.dashboard;

import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteOperatorRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface DashboardOperatorService {

    ResponseModel deleteOperator(DashDeleteOperatorRequestModel dashDeleteOperatorRequestModel);
    ResponseModel fetchAllOperator();
    ResponseModel fetchOperatorDetailsById(int operatorId);
    ResponseModel fetchOperatorActivityLogs(int operatorId);
}
