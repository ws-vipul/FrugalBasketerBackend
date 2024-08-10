package com.frugalbasketer.model.requestmodel.dashboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DashUpdateAdminRequestModel {

    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String email;
    @JsonProperty
    private String mobNum;
    @JsonProperty
    private String password;
    @JsonProperty
    private String adminId;
    @JsonProperty
    private String operatorAdmin;

}
