package com.frugalbasketer.servicesimpl.dashboard;

import com.frugalbasketer.constants.StringConstants;
import com.frugalbasketer.entities.AdminLogsEntity;
import com.frugalbasketer.entities.SellerEntity;
import com.frugalbasketer.entities.SellersLogsEntity;
import com.frugalbasketer.model.requestmodel.dashboard.DashDeleteSellerRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.AdminLogsService;
import com.frugalbasketer.services.SellerLogsService;
import com.frugalbasketer.services.SellersService;
import com.frugalbasketer.services.dashboard.DashboardSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardSellerServiceImpl implements DashboardSellerService {

    @Autowired
    private SellersService sellersService;
    @Autowired
    private SellerLogsService sellerLogsService;
    @Autowired
    private AdminLogsService adminLogsService;

    @Override
    public ResponseModel deleteSeller(DashDeleteSellerRequestModel dashDeleteSellerRequestModel) {
        SellerEntity deletedSeller = sellersService.deleteSeller(dashDeleteSellerRequestModel.getSellerId());
        if (deletedSeller != null) {
            adminLogsService.saveAdminLog(AdminLogsEntity.builder()
                    .adminId(dashDeleteSellerRequestModel.getAdminId())
                    .log("deleted seller with sellerId : " + dashDeleteSellerRequestModel.getSellerId())
                    .reason(dashDeleteSellerRequestModel.getReason())
                    .action(StringConstants.DELETED)
                    .build());

            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .message("Seller deleted Successful").build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("Technical Error in Deleting Seller")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchAllSeller() {
        List<SellerEntity> sellerEntityList = sellersService.getAllSellers();
        if(!sellerEntityList.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(sellerEntityList)
                    .build();
        } else  {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Seller Found")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchSellerDetailsById(int sellerId) {
        SellerEntity sellerEntity = sellersService.getSellerDetails(sellerId);
        if (sellerEntity != null) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(sellerEntity)
                    .build();
        }  else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Seller Details Found")
                    .build();
        }
    }

    @Override
    public ResponseModel fetchSellerActivityLogs(int sellerId) {
        List<SellersLogsEntity> sellersLogsEntityList = sellerLogsService.getSellerLogsBySellerId(sellerId);
        if(!sellersLogsEntityList.isEmpty()) {
            return ResponseModel.builder()
                    .status(StringConstants.SUCCESS)
                    .payload(sellersLogsEntityList)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(StringConstants.FAILED)
                    .message("No Sellers Activity Logs Found")
                    .build();
        }
    }
}
