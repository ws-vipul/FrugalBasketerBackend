package com.frugalbasketer.model.requestmodel.dashboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashDeleteOperatorRequestModel {


    @JsonProperty
    private int operatorId;
    @JsonProperty
    private int adminId;
    @JsonProperty
    private String reason;
}
