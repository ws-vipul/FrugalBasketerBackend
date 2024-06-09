package com.frugalbasketer.services;

import com.frugalbasketer.entities.SellerEntity;
import com.frugalbasketer.entities.UserEntity;
import com.frugalbasketer.model.requestmodel.web.WebSellerRegistrationRequestModel;

import java.util.List;

public interface SellersService {

    SellerEntity getSellerDetails(int sellerId);
    SellerEntity createSeller(WebSellerRegistrationRequestModel webSellerRegistrationRequestModel);
    List<SellerEntity> getAllSellers();
    SellerEntity deleteSeller(int sellerId);
    List<SellerEntity> getAllActiveSeller();
    String getCountOfActiveSeller();
    SellerEntity updateSeller(SellerEntity sellerEntity);
}
