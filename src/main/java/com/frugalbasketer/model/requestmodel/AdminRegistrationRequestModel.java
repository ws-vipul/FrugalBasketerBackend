package com.frugalbasketer.model.requestmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdminRegistrationRequestModel {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mob_num")
    private String mobNum;

    @JsonProperty("password")
    private String password;
}
