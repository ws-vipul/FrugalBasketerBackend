package com.frugalbasketer.services;

import com.frugalbasketer.model.requestmodel.SellerRegistrationRequestModel;
import com.frugalbasketer.model.requestmodel.UserRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface SellersService {

    public ResponseModel getSellerDetails(final int userId);

    public ResponseModel registerSeller(final SellerRegistrationRequestModel sellerRegistrationRequestModel);

    public ResponseModel getAllSellers();
    public ResponseModel deleteSeller(final int userId);
}
