package com.frugalbasketer.controller;

import com.frugalbasketer.constants.ApiConstants;
import com.frugalbasketer.model.requestmodel.dashboard.DashAdminRegistrationRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteAdminRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteOperatorRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteUserRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashSearchedAdminRequestModel;
import com.frugalbasketer.model.requestmodel.dashboard.DashUpdateAdminRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.dashboard.DashboardAdminService;
import com.frugalbasketer.services.dashboard.DashboardOperatorService;
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
    DashboardOperatorService dashboardOperatorService;

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

    @PutMapping(ApiConstants.DASH_DELETE_OPERATOR)
    public ResponseModel deleteOperator(@RequestBody DashDeleteOperatorRequestModel dashDeleteOperatorRequestModel){
        return (dashboardOperatorService.deleteOperator(dashDeleteOperatorRequestModel));
    };

    @GetMapping(ApiConstants.DASH_FETCH_ALL_OPERATORS)
    public ResponseModel fetchOperatorDetails(){
        return dashboardOperatorService.fetchAllOperator();
    };

    @GetMapping(ApiConstants.DASH_FETCH_OPERATORS_DETAILS)
    public ResponseModel fetchOperatorDetails(@PathVariable("operatorId") int operatorId){
        return dashboardOperatorService.fetchOperatorDetailsById(operatorId);
    };

    @GetMapping(ApiConstants.GET_OPERATOR_ACTIVITY_LOGS)
    public ResponseModel fetchOperatorActivityLogs(@PathVariable("operatorId") int operatorId) {
        return dashboardOperatorService.fetchOperatorActivityLogs(operatorId);
    }

    @PostMapping(ApiConstants.DASH_REGISTER_ADMIN)
    public ResponseModel registerAdmin(@RequestBody final DashAdminRegistrationRequestModel dashAdminRegistrationRequestModel) {
        return dashboardAdminService.registerAdmin(dashAdminRegistrationRequestModel);
    };

    @PutMapping(ApiConstants.DASH_UPDATE_ADMIN)
    public ResponseModel updateAdmin(@RequestBody final DashUpdateAdminRequestModel dashUpdateAdminRequestModel) {
        return dashboardAdminService.updateAdmin(dashUpdateAdminRequestModel);
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

    @GetMapping(ApiConstants.FETCH_ADMIN_FOR_TERM)
    public ResponseModel fetchSearchedAdmin(DashSearchedAdminRequestModel dashSearchedAdminRequestModel) {
        return dashboardAdminService.fetchAllAdminSearchedFor(dashSearchedAdminRequestModel);
    }

    @GetMapping(ApiConstants.EXPORT_ADMIN_DATA)
    public ResponseModel exportAdminsData() {
        return dashboardAdminService.fetchAllAdmin();
    }

}
