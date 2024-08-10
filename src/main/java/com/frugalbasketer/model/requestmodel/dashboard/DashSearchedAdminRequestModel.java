package com.frugalbasketer.model.requestmodel.dashboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DashSearchedAdminRequestModel {
    @JsonProperty
    private String term;
    @JsonProperty
    private String searchFor;

}
