package com.frugalbasketer.services.dashboard;

import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteSellerRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;

public interface DashboardSellerService {

    ResponseModel deleteSeller(DashDeleteSellerRequestModel dashDeleteSellerRequestModel);
    ResponseModel fetchAllSeller();
    ResponseModel fetchSellerDetailsById(int sellerId);
}
