package com.frugalbasketer.services.web;

import com.frugalbasketer.model.requestmodel.web.WebSellerRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface WebSellerService {
    ResponseModel registerSeller(WebSellerRegistrationRequestModel webSellerRegistrationRequestModel);

}
