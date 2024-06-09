package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.entities.SellersLogsEntity;
import com.frugalbasketer.repository.SellerLogsRepository;
import com.frugalbasketer.services.SellerLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class SellerLogsServiceImpl implements SellerLogsService {

    @Autowired
    SellerLogsRepository sellerLogsRepository;
    @Override
    public SellersLogsEntity saveSellerLog(SellersLogsEntity sellersLogsEntity) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        var logTime = sdf.format(new Date());

        return sellerLogsRepository.save(SellersLogsEntity.builder()
                .sellerId(sellersLogsEntity.getSellerId())
                .action(sellersLogsEntity.getAction())
                .log(sellersLogsEntity.getLog())
                .reason(sellersLogsEntity.getReason())
                .logDateTime(logTime)
                .build());
    }

    @Override
    public List<SellersLogsEntity> getSellerLogsBySellerId(int sellerId) {
        List<SellersLogsEntity> sellerLogs = sellerLogsRepository.findAllById(Collections.singleton(sellerId));

        if(sellerLogs.isEmpty()) {
            return null;
        }

        return sellerLogs;
    }
}
