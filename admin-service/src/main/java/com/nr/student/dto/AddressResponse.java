package com.nr.student.dto;

import lombok.Data;

@Data
public class AddressResponse {
    private Long studentId;
    private String addressType;  // "present" or "permanent"
    private String flatNumber;
    private String street;
    private String area;
    private String district;
    private String state;
    private String country;
}
