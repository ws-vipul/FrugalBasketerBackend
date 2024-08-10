package com.frugalbasketer.services.web;

import com.frugalbasketer.model.requestmodel.dashboard.DashOperatorRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface WebOperatorService {
    ResponseModel registerOperator(DashOperatorRegistrationRequestModel dashOperatorRegistrationRequestModel);

}
