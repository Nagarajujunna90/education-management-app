package com.nr.student.dto;

import lombok.Data;

@Data
public class TeacherPersonalInfoRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String spouseName;
    private String maritalStatus;
    private Integer children;
    private String dateOfBirth;
    private String disability;
    private String emailId;
    private Integer mobileNumber;
    private Integer alternativeMobileNumber;
    private Integer emergencyContactNumber;
}
