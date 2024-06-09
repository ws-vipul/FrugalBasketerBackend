package com.frugalbasketer.services;

import com.frugalbasketer.entities.SellersLogsEntity;

import java.util.List;

public interface SellerLogsService {

    SellersLogsEntity saveSellerLog(final SellersLogsEntity sellersLogsEntity);

    List<SellersLogsEntity> getSellerLogsBySellerId(final int sellerId);
}
