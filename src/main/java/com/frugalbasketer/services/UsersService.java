package com.frugalbasketer.services;

import com.frugalbasketer.model.requestmodel.UserRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface UsersService {

    public ResponseModel getAllUsers(final int userId);

    public ResponseModel registerUser(final UserRegistrationRequestModel userRegistrationRequestModel);

}
