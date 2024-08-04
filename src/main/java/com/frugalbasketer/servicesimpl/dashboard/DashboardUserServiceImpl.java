package com.frugalbasketer.servicesimpl.dashboard;

import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.AdminLogsEntity;
import com.frugalbasketer.entities.UserEntity;
import com.frugalbasketer.entities.UserLogsEntity;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteUserRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.AdminLogsService;
import com.frugalbasketer.services.UserLogsService;
import com.frugalbasketer.services.UsersService;
import com.frugalbasketer.services.dashboard.DashboardUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardUserServiceImpl implements DashboardUserService {
    @Autowired
    private UsersService usersService;
    @Autowired
    private UserLogsService userLogsService;
    @Autowired
    private AdminLogsService adminLogsService;

    @Override
    public ResponseModel deleteUser(final DashDeleteUserRequestModel dashDeleteUserRequestModel) {
        UserEntity deletedUser = usersService.deleteUser(dashDeleteUserRequestModel.getUserId());
        if (deletedUser != null) {
                adminLogsService.saveAdminLog(AdminLogsEntity.builder()
                        .adminId(dashDeleteUserRequestModel.getAdminId())
                        .log("deleted user with userId : " + dashDeleteUserRequestModel.getUserId())
                        .reason(dashDeleteUserRequestModel.getReason())
                        .action(StringConstants.DELETED)
                        .build());

                return ResponseModel.builder()
                        .status(StringConstants.SUCCESS)
                        .message("User deleted Successful").build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("Technical Error in Deleting User")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchAllUsers() {

        List<UserEntity> userEntityList = usersService.getAllUsers();
        if(!userEntityList.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(userEntityList)
                    .build();
        } else  {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Users Found")
                    .build();
        }

    }

    @Override
    public ResponseModel fetchUserDetailsById(int userId) {
        UserEntity userEntity = usersService.getUserDetails(userId);
        if (userEntity != null) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(userEntity)
                    .build();
        }  else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No User Details Found")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchUserActivityLogs(final int userId) {
        List<UserLogsEntity> userLogsEntityList= userLogsService.getUserLogsByUserId(userId);
        if(!userLogsEntityList.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(userLogsEntityList)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No User Activity Logs Found")
                    .build();
        }

    }

}
