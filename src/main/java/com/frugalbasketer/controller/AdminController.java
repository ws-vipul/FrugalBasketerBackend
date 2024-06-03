package com.frugalbasketer.controller;

import com.frugalbasketer.constants.ApiConstants;
import com.frugalbasketer.model.requestmodel.AdminRegistrationRequestModel;
import com.frugalbasketer.model.requestmodel.SellerRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.AdminService;
import com.frugalbasketer.services.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @PostMapping(ApiConstants.REGISTER_ADMIN)
    public ResponseModel registerAdmin(@RequestBody final AdminRegistrationRequestModel adminRegistrationRequestModel) {
        return adminService.registerAdmin(adminRegistrationRequestModel);
    };

    @GetMapping(ApiConstants.FETCH_ADMIN_DETAILS)
    public ResponseModel fetchAdminDetails(@PathVariable("userid") int userId){
        return adminService.getAdminDetails(userId);
    };

    @GetMapping(ApiConstants.FETCH_ALL_ADMINS)
    public ResponseModel fetchAdminDetails(){
        return adminService.getAllAdmins();
    };

    @PutMapping(ApiConstants.DELETE_ADMIN)
    public ResponseModel deleteAdmin(@PathVariable("userid") int userId){
        return adminService.deleteAdmin(userId);
    };
}
