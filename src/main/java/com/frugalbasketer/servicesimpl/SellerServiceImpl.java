package com.frugalbasketer.servicesimpl;

import com.frugalbasketer.constants.StatusConstants;
import com.frugalbasketer.entities.SellerEntity;
import com.frugalbasketer.entities.UserEntity;
import com.frugalbasketer.model.requestmodel.web.WebSellerRegistrationRequestModel;
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
    public SellerEntity getSellerDetails(int userId) {
        Optional<SellerEntity> sellerEntity = sellerRepository.findById(userId);
        return sellerEntity.orElse(null);
    }

    @Override
    public SellerEntity createSeller(WebSellerRegistrationRequestModel webSellerRegistrationRequestModel) {
        SellerEntity sellerEntity = sellerRepository.findByEmail(webSellerRegistrationRequestModel.getEmail());

        if (sellerEntity == null) {
            return sellerRepository.save(SellerEntity.builder()
                    .firstName(webSellerRegistrationRequestModel.getFirstName())
                    .lastName(webSellerRegistrationRequestModel.getLastName())
                    .email(webSellerRegistrationRequestModel.getEmail())
                    .mobNum(webSellerRegistrationRequestModel.getMobNum())
                    .shopName(webSellerRegistrationRequestModel.getShopName())
                    .shopAddress(webSellerRegistrationRequestModel.getShopAddress())
                    .city(webSellerRegistrationRequestModel.getCity())
                    .password(webSellerRegistrationRequestModel.getPassword())
                    .sellerStatus(StatusConstants.ACTIVE).build());
        } else if (sellerEntity.getSellerStatus().equalsIgnoreCase(StatusConstants.DELETE)) {
            sellerEntity.setSellerStatus(StatusConstants.ACTIVE);
            return  sellerRepository.save(sellerEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<SellerEntity> getAllSellers() {
        List<SellerEntity> sellers = sellerRepository.findAll();
        if (!sellers.isEmpty()) {
            return sellers;
        } else {
            return null;
        }
    }

    @Override
    public SellerEntity deleteSeller(int userId) {
        Optional<SellerEntity> sellerEntity = sellerRepository.findById(userId);
        if (sellerEntity.isPresent()) {
            //Soft deleting user account
            sellerEntity.get().setSellerStatus(StatusConstants.DELETE);
           return sellerRepository.save(sellerEntity.get());

        } else {
            return null;
        }
    }

    @Override
    public List<SellerEntity> getAllActiveSeller() {
        List<SellerEntity> sellerEntityList = sellerRepository.findAllBySellerStatus(StatusConstants.ACTIVE);
        if(!sellerEntityList.isEmpty()) {
            return sellerEntityList;
        } else {
            return null;
        }
    }

    @Override
    public String getCountOfActiveSeller() {
        long userCount = sellerRepository.countBySellerStatus(StatusConstants.ACTIVE);
        return String.valueOf(userCount);
    }

    @Override
    public SellerEntity updateSeller(SellerEntity sellerEntity) {
        Optional<SellerEntity> seller = sellerRepository.findById(sellerEntity.getId());
        if (seller.isPresent()) {
            return sellerRepository.save(SellerEntity.builder()
                            .id(sellerEntity.getId())
                            .firstName(sellerEntity.getFirstName())
                            .lastName(sellerEntity.getLastName())
                            .email(sellerEntity.getEmail())
                            .mobNum(sellerEntity.getMobNum())
                            .city(sellerEntity.getCity())
                            .shopName(sellerEntity.getShopName())
                            .shopAddress(sellerEntity.getShopAddress()).build());
        } else {
            return null;
        }
    }
}
