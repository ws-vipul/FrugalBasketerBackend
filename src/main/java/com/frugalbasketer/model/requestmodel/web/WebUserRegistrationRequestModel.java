package com.frugalbasketer.model.requestmodel.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebUserRegistrationRequestModel {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mob_num")
    private String mobNum;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("city")
    private String city;

    @JsonProperty("password")
    private String password;

}
