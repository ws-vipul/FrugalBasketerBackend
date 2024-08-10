package com.frugalbasketer.model.requestmodel.dashboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashOperatorRegistrationRequestModel {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mob_num")
    private String mobNum;

    @JsonProperty("shop_name")
    private String shopName;

    @JsonProperty("shop_address")
    private String shopAddress;

    @JsonProperty("city")
    private String city;

    @JsonProperty("password")
    private String password;
}
