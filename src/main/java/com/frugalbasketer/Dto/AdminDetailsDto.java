package com.frugalbasketer.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDetailsDto {

    private String firstName;
    private String lastName;
    private String mobNum;
    private String email;
}
