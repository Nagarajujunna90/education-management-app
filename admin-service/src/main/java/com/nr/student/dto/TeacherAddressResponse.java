package com.nr.student.dto;
import lombok.Data;

@Data
public class TeacherAddressResponse {
    private String addressType; // "Permanent" or "Present"
    private String flatNumber;
    private String street;
    private String area;
    private String district;
    private String state;
    private String country;
    private String pinCode;
    private Long teacherId; // Instead of TeacherPersonalInfo object
}

