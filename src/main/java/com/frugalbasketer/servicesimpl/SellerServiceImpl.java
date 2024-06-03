package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.constants.StatusConstants;
import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.SellerEntity;
import com.frugalbasketer.model.requestmodel.SellerRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.repository.SellerRepository;
import com.frugalbasketer.services.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellersService {

    @Autowired
    private SellerRepository sellerRepository;
    @Override
    public ResponseModel getSellerDetails(int userId) {
        Optional<SellerEntity> sellerEntity = sellerRepository.findById(userId);
        if (sellerEntity.isPresent()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(sellerEntity.get())
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .payload(null)
                    .build();
        }
    }

    @Override
    public ResponseModel registerSeller(SellerRegistrationRequestModel sellerRegistrationRequestModel) {
        SellerEntity sellerEntity = sellerRepository.findByEmail(sellerRegistrationRequestModel.getEmail());

        if(sellerEntity == null) {
            sellerRepository.save(SellerEntity.builder()
                    .firstName(sellerRegistrationRequestModel.getFirstName())
                    .lastName(sellerRegistrationRequestModel.getLastName())
                    .email(sellerRegistrationRequestModel.getEmail())
                    .mobNum(sellerRegistrationRequestModel.getMobNum())
                    .shopName(sellerRegistrationRequestModel.getShopName())
                    .shopAddress(sellerRegistrationRequestModel.getShopAddress())
                    .city(sellerRegistrationRequestModel.getCity())
                    .password(sellerRegistrationRequestModel.getPassword())
                    .sellerStatus(StatusConstants.ACTIVE).build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(SellerEntity.builder()
                            .firstName(sellerRegistrationRequestModel.getFirstName())
                            .lastName(sellerRegistrationRequestModel.getLastName())
                            .email(sellerRegistrationRequestModel.getEmail())
                            .mobNum(sellerRegistrationRequestModel.getMobNum())
                            .shopName(sellerRegistrationRequestModel.getShopName())
                            .shopAddress(sellerRegistrationRequestModel.getShopAddress())
                            .city(sellerRegistrationRequestModel.getCity())
                            .sellerStatus(StatusConstants.ACTIVE).build())
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
    public ResponseModel getAllSellers() {
        List<SellerEntity> sellers = sellerRepository.findAll();
        if(!sellers.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(sellers)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Sellers Found")
                    .build();
        }
    }

    @Override
    public ResponseModel deleteSeller(int userId) {
        Optional<SellerEntity> sellerEntity= sellerRepository.findById(userId);
        if(sellerEntity.isPresent()) {
            //Soft deleting user account
            sellerEntity.get().setSellerStatus(StatusConstants.DELETE);
            sellerRepository.save(sellerEntity.get());
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .message("Deleted Seller Successfully")
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Seller Found, Can't Delete")
                    .build();
        }
    }
}
