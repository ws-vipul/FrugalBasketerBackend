package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.constants.StatusConstants;
import com.frugalbasketer.entities.UserEntity;
import com.frugalbasketer.model.requestmodel.web.WebUserRegistrationRequestModel;
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
    public UserEntity getUserDetails(final int userId) {

        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return userEntity.orElse(null);
    }

    @Override
    public UserEntity createUser(final WebUserRegistrationRequestModel webUserRegistrationRequestModel) {

        UserEntity userEntity= userRepository.findByEmail(webUserRegistrationRequestModel.getEmail());

        if(userEntity == null) {
            return userRepository.save(UserEntity.builder()
                    .firstName(webUserRegistrationRequestModel.getFirstName())
                    .lastName(webUserRegistrationRequestModel.getLastName())
                    .email(webUserRegistrationRequestModel.getEmail())
                    .mobNum(webUserRegistrationRequestModel.getMobNum())
                    .gender(webUserRegistrationRequestModel.getGender())
                    .city(webUserRegistrationRequestModel.getCity())
                    .password(webUserRegistrationRequestModel.getPassword())
                    .userStatus(StatusConstants.ACTIVE).build());

        } else if(userEntity.getUserStatus().equalsIgnoreCase(StatusConstants.DELETE)){
            userEntity.setUserStatus(StatusConstants.ACTIVE);
            return userRepository.save(userEntity);
        } else {
            return null;
        }

    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        if(!users.isEmpty()) {
           return users;
        } else {
            return null;
        }
    }

    @Override
    public UserEntity deleteUser(int userId) {

        Optional<UserEntity> userEntity= userRepository.findById(userId);
        if(userEntity.isPresent()) {
            //Soft deleting user account
            userEntity.get().setUserStatus(StatusConstants.DELETE);
            return userRepository.save(userEntity.get());
        } else {
            return null;
        }
    }

    @Override
    public List<UserEntity> getAllActiveUsers() {
        List<UserEntity> userEntityList= userRepository.findAllByUserStatus(StatusConstants.ACTIVE);
        if(!userEntityList.isEmpty()) {
            return userEntityList;
        } else {
            return null;
        }
    }

    @Override
    public String getCountOfActiveUser() {
        long userCount = userRepository.countByUserStatus(StatusConstants.ACTIVE);
        return String.valueOf(userCount);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        Optional<UserEntity> userToUpdate = userRepository.findById(userEntity.getId());
        if(userToUpdate.isPresent()) {
            return userRepository.save(UserEntity.builder()
                            .id(userEntity.getId())
                            .firstName(userEntity.getFirstName())
                            .lastName(userEntity.getLastName())
                            .email(userEntity.getEmail())
                            .mobNum(userEntity.getMobNum())
                            .gender(userEntity.getGender())
                            .city(userEntity.getCity())
                    .build());
        } else {
            return null;
        }
    }

}
