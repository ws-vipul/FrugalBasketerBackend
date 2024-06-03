package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.constants.StatusConstants;
import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.UserEntity;
import com.frugalbasketer.model.requestmodel.UserRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.repository.UserRepository;
import com.frugalbasketer.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    static Logger log = Logger.getLogger(UsersServiceImpl.class.getName());
    @Override
    public ResponseModel getUserDetails(final int userId) {

        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isEmpty()) {
            log.info("user not found for user id "+userId);
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .payload(null)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(userEntity.get())
                    .build();
        }
    }

    @Override
    public ResponseModel registerUser(final UserRegistrationRequestModel userRegistrationRequestModel) {

        UserEntity userEntity= userRepository.findByEmail(userRegistrationRequestModel.getEmail());

        if(userEntity == null) {
            userRepository.save(UserEntity.builder()
                    .firstName(userRegistrationRequestModel.getFirstName())
                    .lastName(userRegistrationRequestModel.getLastName())
                    .email(userRegistrationRequestModel.getEmail())
                    .mobNum(userRegistrationRequestModel.getMobNum())
                    .gender(userRegistrationRequestModel.getGender())
                    .city(userRegistrationRequestModel.getCity())
                    .password(userRegistrationRequestModel.getPassword())
                    .userStatus(StatusConstants.ACTIVE).build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(UserEntity.builder()
                            .firstName(userRegistrationRequestModel.getFirstName())
                            .lastName(userRegistrationRequestModel.getLastName())
                            .email(userRegistrationRequestModel.getEmail())
                            .mobNum(userRegistrationRequestModel.getMobNum())
                            .gender(userRegistrationRequestModel.getGender())
                            .city(userRegistrationRequestModel.getCity())
                            .userStatus(StatusConstants.ACTIVE).build())
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
    public ResponseModel getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        if(!users.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(users)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Users Found")
                    .build();
        }
    }

    @Override
    public ResponseModel deleteUser(int userId) {

        Optional<UserEntity> userEntity= userRepository.findById(userId);
        if(userEntity.isPresent()) {
            //Soft deleting user account
            userEntity.get().setUserStatus(StatusConstants.DELETE);
            userRepository.save(userEntity.get());
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .message("Deleted User Successfully")
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No User Found, Can't Delete")
                    .build();
        }
    }
}
