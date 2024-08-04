package com.frugalbasketer.services.dashboard;

import com.frugalbasketer.model.requestmodel.dashboard.DashAdminRegistrationRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteAdminRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface DashboardAdminService {

    ResponseModel registerAdmin(DashAdminRegistrationRequestModel dashAdminRegistrationRequestModel);
    ResponseModel deleteAdmin(DashDeleteAdminRequestModel dashDeleteAdminRequestModel);
    ResponseModel fetchAllAdmin();
    ResponseModel fetchAdminDetailsById(int adminId);
    ResponseModel fetchAdminActivityLogs(int adminId);
}
