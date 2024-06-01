package com.frugalbasketer.model.responsemodel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseModel {

    String message;
    Object payload;
    String status;
}
