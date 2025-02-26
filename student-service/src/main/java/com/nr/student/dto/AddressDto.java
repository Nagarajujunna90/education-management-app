package com.nr.student.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String houseNumber;
    private String street;
    private String area;
    private String village;
    private String mandal;
    private String district;
    private String state;
    private String country;
    private Integer pinCode;
}
