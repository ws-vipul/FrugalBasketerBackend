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

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    static Logger log = Logger.getLogger(UsersServiceImpl.class.getName());
    @Override
    public ResponseModel getAllUsers(final int userId) {

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
                    .mobNum(userRegistrationRequestModel.getEmail())
                    .gender(userRegistrationRequestModel.getGender())
                    .city(userRegistrationRequestModel.getCity())
                    .userStatus(StatusConstants.ACTIVE).build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(UserEntity.builder()
                            .firstName(userRegistrationRequestModel.getFirstName())
                            .lastName(userRegistrationRequestModel.getLastName())
                            .email(userRegistrationRequestModel.getEmail())
                            .mobNum(userRegistrationRequestModel.getEmail())
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
}
