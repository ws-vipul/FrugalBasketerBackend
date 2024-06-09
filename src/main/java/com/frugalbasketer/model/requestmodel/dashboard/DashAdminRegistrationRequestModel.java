package com.frugalbasketer.model.requestmodel.dashboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DashAdminRegistrationRequestModel {

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

    @JsonProperty("adminId")
    private int adminId;
}
