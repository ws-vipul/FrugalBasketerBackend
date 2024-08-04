package com.frugalbasketer.controller;

import com.frugalbasketer.constants.ApiConstants;
import com.frugalbasketer.model.requestmodel.dashboard.DashAdminRegistrationRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteAdminRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteSellerRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteUserRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.dashboard.DashboardAdminService;
import com.frugalbasketer.services.dashboard.DashboardSellerService;
import com.frugalbasketer.services.dashboard.DashboardUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    DashboardUserService dashboardUserService;
    @Autowired
    DashboardAdminService dashboardAdminService;
    @Autowired
    DashboardSellerService dashboardSellerService;

    @PutMapping(ApiConstants.DASH_DELETE_USER)
    public ResponseModel deleteUser(@RequestBody DashDeleteUserRequestModel dashDeleteUserRequestModel){
        return (dashboardUserService.deleteUser(dashDeleteUserRequestModel));
    };

    @GetMapping(ApiConstants.DASH_FETCH_ALL_USER)
    public ResponseModel fetchUserDetails(){
        return dashboardUserService.fetchAllUsers();
    };

    @GetMapping(ApiConstants.DASH_FETCH_USER_DETAILS)
    public ResponseModel fetchUserDetails(@PathVariable("userid") int userId){
        return dashboardUserService.fetchUserDetailsById(userId);
    };

    @GetMapping(ApiConstants.GET_USER_LOGS)
    public ResponseModel fetchUserActivityLogs(@PathVariable("userId") int userId) {
        return dashboardUserService.fetchUserActivityLogs(userId);
    }

    @PutMapping(ApiConstants.DASH_DELETE_SELLER)
    public ResponseModel deleteSeller(@RequestBody DashDeleteSellerRequestModel dashDeleteSellerRequestModel){
        return (dashboardSellerService.deleteSeller(dashDeleteSellerRequestModel));
    };

    @GetMapping(ApiConstants.DASH_FETCH_ALL_SELLERS)
    public ResponseModel fetchSellerDetails(){
        return dashboardSellerService.fetchAllSeller();
    };

    @GetMapping(ApiConstants.DASH_FETCH_SELLERS_DETAILS)
    public ResponseModel fetchSellerDetails(@PathVariable("sellerId") int sellerId){
        return dashboardSellerService.fetchSellerDetailsById(sellerId);
    };

    @GetMapping(ApiConstants.GET_SELLER_ACTIVITY_LOGS)
    public ResponseModel fetchSellerActivityLogs(@PathVariable("sellerId") int sellerId) {
        return dashboardSellerService.fetchSellerActivityLogs(sellerId);
    }

    @PostMapping(ApiConstants.DASH_REGISTER_ADMIN)
    public ResponseModel registerAdmin(@RequestBody final DashAdminRegistrationRequestModel dashAdminRegistrationRequestModel) {
        return dashboardAdminService.registerAdmin(dashAdminRegistrationRequestModel);
    };

    @GetMapping(ApiConstants.DASH_FETCH_ADMIN_DETAILS)
    public ResponseModel fetchAdminDetails(@PathVariable("adminId") int adminId){
        return dashboardAdminService.fetchAdminDetailsById(adminId);
    };

    @GetMapping(ApiConstants.DASH_FETCH_ALL_ADMIN)
    public ResponseModel fetchAdminDetails(){
        return dashboardAdminService.fetchAllAdmin();
    };

    @PutMapping(ApiConstants.DASH_DELETE_ADMIN)
    public ResponseModel deleteAdmin(@RequestBody DashDeleteAdminRequestModel dashDeleteAdminRequestModel){
        return dashboardAdminService.deleteAdmin(dashDeleteAdminRequestModel);
    };

    @GetMapping(ApiConstants.GET_ADMIN_ACTIVITY_LOGS)
    public ResponseModel getAdminActivityLogs(@PathVariable("adminId") int adminId) {
        return dashboardAdminService.fetchAdminActivityLogs(adminId);
    }

}
