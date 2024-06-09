package com.frugalbasketer.model.requestmodel.dashboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DashDeleteAdminRequestModel {

    @JsonProperty
    private int userAdminId;
    @JsonProperty
    private int adminId;
    @JsonProperty
    private String reason;
}
