package com.frugalbasketer.services;

import com.frugalbasketer.model.requestmodel.AdminRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface AdminService {
    public ResponseModel getAdminDetails(final int userId);
    public ResponseModel registerAdmin(final AdminRegistrationRequestModel adminRegistrationRequestModel);
    public ResponseModel getAllAdmins();
    public ResponseModel deleteAdmin(final int userId);
}
