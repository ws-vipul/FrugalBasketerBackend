package com.frugalbasketer.services;

import com.frugalbasketer.model.requestmodel.UserRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface UsersService {

    public ResponseModel getUserDetails(final int userId);

    public ResponseModel registerUser(final UserRegistrationRequestModel userRegistrationRequestModel);

    public ResponseModel getAllUsers();
    public ResponseModel deleteUser(final int userId);
}
