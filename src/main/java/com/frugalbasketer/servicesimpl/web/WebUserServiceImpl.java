package com.frugalbasketer.servicesimpl.web;

import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.OperatorsLogsEntity;
import com.frugalbasketer.entities.UserEntity;
import com.frugalbasketer.entities.UserLogsEntity;
import com.frugalbasketer.model.requestmodel.web.WebUserRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.UserLogsService;
import com.frugalbasketer.services.UsersService;
import com.frugalbasketer.services.web.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    UsersService usersService;
    @Autowired
    UserLogsService userLogsService;

    @Override
    public ResponseModel registerUser(WebUserRegistrationRequestModel webUserRegistrationRequestModel) {

        UserEntity userEntity= usersService.createUser(webUserRegistrationRequestModel);

        if(userEntity != null) {

            userLogsService.saveUserLog(UserLogsEntity.builder()
                    .userId(userEntity.getId())
                    .action(StringConstants.CREATED)
                    .reason(StringConstants.NA)
                    .log("created account")
                    .build());
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(userEntity)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("There is already an account with this email Id")
                    .build();
        }
    }

}
