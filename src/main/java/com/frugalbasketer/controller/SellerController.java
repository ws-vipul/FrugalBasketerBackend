package com.frugalbasketer.controller;

import com.frugalbasketer.constants.ApiConstants;
import com.frugalbasketer.model.requestmodel.SellerRegistrationRequestModel;
import com.frugalbasketer.model.responsemodel.ResponseModel;
import com.frugalbasketer.services.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller/api")
public class SellerController {

    @Autowired
    private SellersService sellersService;


    @PostMapping(ApiConstants.REGISTER_SELLER)
    public ResponseModel registerUser(@RequestBody final SellerRegistrationRequestModel sellerRegistrationRequestModel) {
        return sellersService.registerSeller(sellerRegistrationRequestModel);
    };

    @GetMapping(ApiConstants.FETCH_SELLERS_DETAILS)
    public ResponseModel fetchUserDetails(@PathVariable("userid") int userId){
        return sellersService.getSellerDetails(userId);
    };

    @GetMapping(ApiConstants.FETCH_ALL_SELLERS)
    public ResponseModel fetchUserDetails(){
        return sellersService.getAllSellers();
    };

    @PutMapping(ApiConstants.DELETE_SELLER)
    public ResponseModel deleteUser(@PathVariable("userid") int userId){
        return sellersService.deleteSeller(userId);
    };

}
