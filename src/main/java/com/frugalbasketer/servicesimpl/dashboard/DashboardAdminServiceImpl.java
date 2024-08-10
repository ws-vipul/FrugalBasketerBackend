package com.frugalbasketer.servicesimpl.dashboard;

import com.frugalbasketer.Dto.AdminDetailsDto;
import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.AdminEntity;
import com.frugalbasketer.entities.AdminLogsEntity;
import com.frugalbasketer.model.requestmodel.dashboard.DashAdminRegistrationRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteAdminRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashSearchedAdminRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashUpdateAdminRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.AdminLogsService;
import com.frugalbasketer.services.AdminService;
import com.frugalbasketer.services.dashboard.DashboardAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardAdminServiceImpl implements DashboardAdminService {

    @Autowired
    AdminService adminService;
    @Autowired
    AdminLogsService adminLogsService;

    @Override
    public ResponseModel registerAdmin(DashAdminRegistrationRequestModel dashAdminRegistrationRequestModel) {

        AdminEntity adminEntity= adminService.createAdmin(dashAdminRegistrationRequestModel);

        if(adminEntity != null) {

            adminLogsService.saveAdminLog(AdminLogsEntity.builder()
                    .adminId(dashAdminRegistrationRequestModel.getAdminId())
                    .action(StringConstants.CREATED)
                    .log("Created Admin Account" + adminEntity.getId())
                    .build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(adminEntity)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("There is already an account with this email Id")
                    .build();
        }
    }

    @Override
    public ResponseModel updateAdmin(DashUpdateAdminRequestModel dashUpdateAdminRequestModel) {

        var updateAdmin = AdminEntity.builder()
                .id(Integer.parseInt(dashUpdateAdminRequestModel.getAdminId()))
                .firstName(dashUpdateAdminRequestModel.getFirstName())
                .lastName(dashUpdateAdminRequestModel.getLastName())
                .email(dashUpdateAdminRequestModel.getEmail())
                .mobNum(dashUpdateAdminRequestModel.getMobNum())
                .password(dashUpdateAdminRequestModel.getPassword())
                .build();

        var updatedAdmin = adminService.updateAdmin(updateAdmin);

        if (updatedAdmin != null) {
            adminLogsService.saveAdminLog(AdminLogsEntity.builder()
                    .adminId(Integer.parseInt(dashUpdateAdminRequestModel.getOperatorAdmin()))
                    .log("updated admin with adminId : " + dashUpdateAdminRequestModel.getAdminId())
                    .reason(StringConstants.NA)
                    .action(StringConstants.UPDATED)
                    .build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .message("Admin Updated Successful").build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("Technical Error in Updating Admin Account")
                    .build();
        }
    }

    @Override
    public ResponseModel deleteAdmin(final DashDeleteAdminRequestModel dashDeleteAdminRequestModel) {
        AdminEntity deletedUser = adminService.deleteAdmin(dashDeleteAdminRequestModel.getUserAdminId());
        if (deletedUser != null) {
            adminLogsService.saveAdminLog(AdminLogsEntity.builder()
                    .adminId(dashDeleteAdminRequestModel.getAdminId())
                    .log("deleted user with userId : " + dashDeleteAdminRequestModel.getUserAdminId())
                    .reason(dashDeleteAdminRequestModel.getReason())
                    .action(StringConstants.DELETED)
                    .build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .message("Admin deleted Successful").build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("Technical Error in Deleting Admin Account")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchAllAdmin() {
        List<AdminEntity> adminEntityList = adminService.getAllAdmins();
        List<AdminDetailsDto> adminsDetail = adminEntityList.stream().map(adminEntity -> AdminDetailsDto.builder()
                .firstName(adminEntity.getFirstName())
                .lastName(adminEntity.getLastName())
                .mobNum(adminEntity.getMobNum())
                .email(adminEntity.getEmail()).build()).toList();

        if(!adminsDetail.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(adminEntityList)
                    .build();
        } else  {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Admin Found")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchAdminDetailsById(int adminId) {
        AdminEntity adminEntity= adminService.getAdminDetails(adminId);
        if (adminEntity != null) {
           return ResponseModel.builder()
                   .status(StringConstants.SUCCESS)
                   .payload(adminEntity)
                   .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Admin Details Found")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchAdminActivityLogs(int adminId) {
        List<AdminLogsEntity> adminLogsEntityList = adminLogsService.getAdminLogsByAdminId(adminId);
        if(adminLogsEntityList != null) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(adminLogsEntityList)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Admin Activity Logs Found")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchAllAdminSearchedFor(DashSearchedAdminRequestModel dashSearchedAdminRequestModel) {

        List<AdminEntity> adminEntityList= adminService.getAllAdminsForTerm(dashSearchedAdminRequestModel.getTerm(),
                dashSearchedAdminRequestModel.getSearchFor());

        return adminEntityList.isEmpty() ?
                ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Admin Found For Searched Term").build() :
                ResponseModel.builder()
                        .status(StringConstants.SUCCESS)
                        .payload(adminEntityList).build();
    }
}
