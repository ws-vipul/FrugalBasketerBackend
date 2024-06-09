package com.frugalbasketer.services;

import com.frugalbasketer.entities.UserEntity;
import com.frugalbasketer.model.requestmodel.web.WebUserRegistrationRequestModel;

import java.util.List;

public interface UsersService {

    UserEntity getUserDetails(final int userId);
    UserEntity createUser(final WebUserRegistrationRequestModel webUserRegistrationRequestModel);
    List<UserEntity> getAllUsers();
    UserEntity deleteUser(final int userId);
    List<UserEntity> getAllActiveUsers();
    String getCountOfActiveUser();
    UserEntity updateUser(UserEntity userEntity);
}
