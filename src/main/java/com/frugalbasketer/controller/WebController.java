package com.frugalbasketer.controller;

import com.frugalbasketer.constants.ApiConstants;
import com.frugalbasketer.model.requestmodel.web.WebSellerRegistrationRequestModel;
import com.frugalbasketer.model.requestmodel.web.WebUserRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.web.WebSellerService;
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
    WebSellerService webSellerService;

    @PostMapping(ApiConstants.WEB_REGISTER_USER)
    public ResponseModel registerUser(
            @RequestBody final WebUserRegistrationRequestModel webUserRegistrationRequestModel) {
        return webUserService.registerUser(webUserRegistrationRequestModel);
    };

    @PostMapping(ApiConstants.WEB_REGISTER_SELLER)
    public ResponseModel registerSeller(
            @RequestBody final WebSellerRegistrationRequestModel webSellerRegistrationRequestModel) {
        return webSellerService.registerSeller(webSellerRegistrationRequestModel);
    };
}
