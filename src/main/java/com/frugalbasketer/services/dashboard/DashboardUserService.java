package com.frugalbasketer.services.dashboard;

import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteUserRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface DashboardUserService {

    ResponseModel deleteUser(DashDeleteUserRequestModel dashDeleteUserRequestModel);
    ResponseModel fetchAllUsers();
    ResponseModel fetchUserDetailsById(int userId);


}
