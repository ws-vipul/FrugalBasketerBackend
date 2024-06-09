package com.frugalbasketer.services.web;

import com.frugalbasketer.model.requestmodel.web.WebUserRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface WebUserService {

    ResponseModel registerUser(WebUserRegistrationRequestModel webUserRegistrationRequestModel);
}
