package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.constants.StatusConstants;
import com.frugalbasketer.entities.AdminEntity;
import com.frugalbasketer.entities.UserEntity;
import com.frugalbasketer.model.requestmodel.dashboard.DashAdminRegistrationRequestModel;
import com.frugalbasketer.repository.AdminRepository;
import com.frugalbasketer.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public AdminEntity getAdminDetails(int userId) {
        Optional<AdminEntity> adminEntity = adminRepository.findById(userId);
        return adminEntity.orElse(null);
    }

    @Override
    public AdminEntity createAdmin(DashAdminRegistrationRequestModel dashAdminRegistrationRequestModel) {
        AdminEntity adminEntity = adminRepository.findByEmail(dashAdminRegistrationRequestModel.getEmail());

        if (adminEntity == null) {
            return adminRepository.save(AdminEntity.builder()
                    .firstName(dashAdminRegistrationRequestModel.getFirstName())
                    .lastName(dashAdminRegistrationRequestModel.getLastName())
                    .email(dashAdminRegistrationRequestModel.getEmail())
                    .mobNum(dashAdminRegistrationRequestModel.getMobNum())
                    .password(dashAdminRegistrationRequestModel.getPassword())
                    .adminStatus(StatusConstants.ACTIVE).build());

        } else if (adminEntity.getAdminStatus().equalsIgnoreCase(StatusConstants.DELETE)) {
            adminEntity.setAdminStatus(StatusConstants.ACTIVE);
            return adminRepository.save(adminEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<AdminEntity> getAllAdmins() {
        List<AdminEntity> adminEntities = adminRepository.findAll();
        if (!adminEntities.isEmpty()) {
            return adminEntities;
        } else {
            return null;
        }
    }

    @Override
    public AdminEntity deleteAdmin(int adminId) {
        Optional<AdminEntity> adminEntity = adminRepository.findById(adminId);
        if (adminEntity.isPresent()) {
            //Soft deleting user account
            adminEntity.get().setAdminStatus(StatusConstants.DELETE);
            return adminRepository.save(adminEntity.get());
        } else {
            return null;
        }
    }

    @Override
    public List<AdminEntity> getAllActiveAdmin() {
        List<AdminEntity> adminEntityList = adminRepository.findAllByAdminStatus(StatusConstants.ACTIVE);
        if (!adminEntityList.isEmpty()) {
            return adminEntityList;
        } else {
            return null;
        }
    }

    @Override
    public String getCountOfActiveAdmin() {
        long userCount = adminRepository.countByAdminStatus(StatusConstants.ACTIVE);
        return String.valueOf(userCount);
    }

    @Override
    public AdminEntity updateAdmin(AdminEntity adminEntity) {
        Optional<AdminEntity> adminToUpdate = adminRepository.findById(adminEntity.getId());
        if (adminToUpdate.isPresent()) {
            return adminRepository.save(AdminEntity.builder()
                    .id(adminEntity.getId())
                    .firstName(adminEntity.getFirstName())
                    .lastName(adminEntity.getLastName())
                    .email(adminEntity.getEmail())
                    .mobNum(adminEntity.getMobNum()).build());
        } else {
            return null;
        }
    }
}
