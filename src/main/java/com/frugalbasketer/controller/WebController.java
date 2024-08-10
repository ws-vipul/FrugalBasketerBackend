package com.frugalbasketer.controller;

import com.frugalbasketer.constants.ApiConstants;
import com.frugalbasketer.model.requestmodel.dashboard.DashOperatorRegistrationRequestModel;
import com.frugalbasketer.model.requestmodel.web.WebUserRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.web.WebOperatorService;
import com.frugalbasketer.services.web.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web/")
public class WebController {

    @Autowired
    WebUserService webUserService;
    @Autowired
    WebOperatorService webOperatorService;

    @PostMapping(ApiConstants.WEB_REGISTER_USER)
    public ResponseModel registerUser(
            @RequestBody final WebUserRegistrationRequestModel webUserRegistrationRequestModel) {
        return webUserService.registerUser(webUserRegistrationRequestModel);
    };

    @PostMapping(ApiConstants.WEB_REGISTER_OPERATOR)
    public ResponseModel registerOperator(
            @RequestBody final DashOperatorRegistrationRequestModel dashOperatorRegistrationRequestModel) {
        return webOperatorService.registerOperator(dashOperatorRegistrationRequestModel);
    };
}
