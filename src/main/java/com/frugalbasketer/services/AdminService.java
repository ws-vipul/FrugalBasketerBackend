package com.frugalbasketer.services;

import com.frugalbasketer.entities.AdminEntity;
import com.frugalbasketer.entities.UserEntity;
import com.frugalbasketer.model.requestmodel.dashboard.DashAdminRegistrationRequestModel;

import java.util.List;

public interface AdminService {
    AdminEntity getAdminDetails(final int adminId);
    AdminEntity createAdmin(final DashAdminRegistrationRequestModel dashAdminRegistrationRequestModel);
    List<AdminEntity> getAllAdmins();
    List<AdminEntity> getAllAdminsForTerm(final String term, final String searchFor);
    AdminEntity deleteAdmin(final int adminId);
    List<AdminEntity> getAllActiveAdmin();
    String getCountOfActiveAdmin();
    AdminEntity updateAdmin(AdminEntity adminEntity);
}
