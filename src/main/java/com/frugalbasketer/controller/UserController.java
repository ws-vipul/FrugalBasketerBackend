package com.frugalbasketer.controller;

import com.frugalbasketer.constants.ApiConstants;
import com.frugalbasketer.model.requestmodel.UserRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api")
public class UserController {

    @Autowired
    private UsersService usersService;


    @PostMapping(ApiConstants.REGISTER_USER)
    public ResponseModel registerUser(@RequestBody final UserRegistrationRequestModel userRegistrationRequestModel) {
      return usersService.registerUser(userRegistrationRequestModel);
    };

    @GetMapping(ApiConstants.FETCH_USER_DETAILS)
    public ResponseModel fetchUserDetails(@PathVariable("userid") int userId){
        return usersService.getAllUsers(userId);
    };
}
