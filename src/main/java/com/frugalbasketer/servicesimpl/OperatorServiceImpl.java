package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.constants.StatusConstants;
import com.frugalbasketer.entities.OperatorEntity;
import com.frugalbasketer.model.requestmodel.dashboard.DashOperatorRegistrationRequestModel;
import com.frugalbasketer.repository.OperatorRepository;
import com.frugalbasketer.services.OperatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperatorServiceImpl implements OperatorsService {
    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public OperatorEntity getOperatorDetails(int userId) {
        Optional<OperatorEntity> operatorEntity = operatorRepository.findById(userId);
        return operatorEntity.orElse(null);
    }

    @Override
    public OperatorEntity createOperator(DashOperatorRegistrationRequestModel dashOperatorRegistrationRequestModel) {
        OperatorEntity operatorEntity = operatorRepository.findByEmail(dashOperatorRegistrationRequestModel.getEmail());

        if (operatorEntity == null) {
            return operatorRepository.save(OperatorEntity.builder()
                    .firstName(dashOperatorRegistrationRequestModel.getFirstName())
                    .lastName(dashOperatorRegistrationRequestModel.getLastName())
                    .email(dashOperatorRegistrationRequestModel.getEmail())
                    .mobNum(dashOperatorRegistrationRequestModel.getMobNum())
                    .shopName(dashOperatorRegistrationRequestModel.getShopName())
                    .shopAddress(dashOperatorRegistrationRequestModel.getShopAddress())
                    .city(dashOperatorRegistrationRequestModel.getCity())
                    .password(dashOperatorRegistrationRequestModel.getPassword())
                    .operatorStatus(StatusConstants.ACTIVE).build());
        } else if (operatorEntity.getOperatorStatus().equalsIgnoreCase(StatusConstants.DELETE)) {
            operatorEntity.setOperatorStatus(StatusConstants.ACTIVE);
            return  operatorRepository.save(operatorEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<OperatorEntity> getAllOperators() {
        List<OperatorEntity> operators = operatorRepository.findAll();
        if (!operators.isEmpty()) {
            return operators;
        } else {
            return null;
        }
    }

    @Override
    public OperatorEntity deleteOperator(int userId) {
        Optional<OperatorEntity> operatorEntity = operatorRepository.findById(userId);
        if (operatorEntity.isPresent()) {
            //Soft deleting user account
            operatorEntity.get().setOperatorStatus(StatusConstants.DELETE);
           return operatorRepository.save(operatorEntity.get());

        } else {
            return null;
        }
    }

    @Override
    public List<OperatorEntity> getAllActiveOperator() {
        List<OperatorEntity> operatorEntityList = operatorRepository.findAllByOperatorStatus(StatusConstants.ACTIVE);
        if(!operatorEntityList.isEmpty()) {
            return operatorEntityList;
        } else {
            return null;
        }
    }

    @Override
    public String getCountOfActiveOperator() {
        long userCount = operatorRepository.countByOperatorStatus(StatusConstants.ACTIVE);
        return String.valueOf(userCount);
    }

    @Override
    public OperatorEntity updateOperator(OperatorEntity operatorEntity) {
        Optional<OperatorEntity> operator = operatorRepository.findById(operatorEntity.getId());
        if (operator.isPresent()) {
            return operatorRepository.save(OperatorEntity.builder()
                            .id(operatorEntity.getId())
                            .firstName(operatorEntity.getFirstName())
                            .lastName(operatorEntity.getLastName())
                            .email(operatorEntity.getEmail())
                            .mobNum(operatorEntity.getMobNum())
                            .city(operatorEntity.getCity())
                            .shopName(operatorEntity.getShopName())
                            .shopAddress(operatorEntity.getShopAddress()).build());
        } else {
            return null;
        }
    }
}
