package com.nr.student.dto;

import lombok.Data;

@Data
public class StudentAddressResponse {
    private Long addressId;
    private Long studentId;
    private String addressType;  // "present" or "permanent"
    private String houseNumber;
    private String area;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String landMark;
}
