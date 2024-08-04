package com.frugalbasketer.servicesimpl.web;

import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.SellerEntity;
import com.frugalbasketer.entities.SellersLogsEntity;
import com.frugalbasketer.model.requestmodel.web.WebSellerRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.SellerLogsService;
import com.frugalbasketer.services.SellersService;
import com.frugalbasketer.services.web.WebSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSellerServiceImpl implements WebSellerService {

    @Autowired
    private SellersService sellersService;
    @Autowired
    private SellerLogsService sellerLogsService;

    @Override
    public ResponseModel registerSeller(WebSellerRegistrationRequestModel webSellerRegistrationRequestModel) {
        SellerEntity sellerEntity= sellersService.createSeller(webSellerRegistrationRequestModel);

        if(sellerEntity != null) {

            sellerLogsService.saveSellerLog(SellersLogsEntity.builder()
                    .sellerId(sellerEntity.getId())
                    .action(StringConstants.CREATED)
                    .reason(StringConstants.NA)
                    .log("created account")
                    .build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(sellerEntity)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("There is already an account with this email Id")
                    .build();
        }
    }
}
