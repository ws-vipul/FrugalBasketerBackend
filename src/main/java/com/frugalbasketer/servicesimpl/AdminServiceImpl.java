package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.constants.StatusConstants;
import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.AdminEntity;
import com.frugalbasketer.model.requestmodel.AdminRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.repository.AdminRepository;
import com.frugalbasketer.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public ResponseModel getAdminDetails(int userId) {
        Optional<AdminEntity> adminEntity = adminRepository.findById(userId);
        if (adminEntity.isPresent()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(adminEntity.get())
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .payload(null)
                    .build();
        }
    }

    @Override
    public ResponseModel registerAdmin(AdminRegistrationRequestModel adminRegistrationRequestModel) {
        AdminEntity adminEntity = adminRepository.findByEmail(adminRegistrationRequestModel.getEmail());

        if(adminEntity == null) {
            adminRepository.save(AdminEntity.builder()
                    .firstName(adminRegistrationRequestModel.getFirstName())
                    .lastName(adminRegistrationRequestModel.getLastName())
                    .email(adminRegistrationRequestModel.getEmail())
                    .mobNum(adminRegistrationRequestModel.getMobNum())
                    .password(adminRegistrationRequestModel.getPassword())
                    .adminStatus(StatusConstants.ACTIVE).build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(AdminEntity.builder()
                            .firstName(adminRegistrationRequestModel.getFirstName())
                            .lastName(adminRegistrationRequestModel.getLastName())
                            .email(adminRegistrationRequestModel.getEmail())
                            .mobNum(adminRegistrationRequestModel.getMobNum())
                            .adminStatus(StatusConstants.ACTIVE).build())
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .payload(null)
                    .message("THERE IS ALREADY AN ACTIVE ACCOUNT WITH THIS EMAIL ID")
                    .build();
        }
    }

    @Override
    public ResponseModel getAllAdmins() {
        List<AdminEntity> adminEntities = adminRepository.findAll();
        if(!adminEntities.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(adminEntities)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Admins Found")
                    .build();
        }
    }

    @Override
    public ResponseModel deleteAdmin(int userId) {
        Optional<AdminEntity> adminEntity= adminRepository.findById(userId);
        if(adminEntity.isPresent()) {
            //Soft deleting user account
            adminEntity.get().setAdminStatus(StatusConstants.DELETE);
            adminRepository.save(adminEntity.get());
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .message("Deleted Admin Successfully")
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Admin Found, Can't Delete")
                    .build();
        }
    }
}
