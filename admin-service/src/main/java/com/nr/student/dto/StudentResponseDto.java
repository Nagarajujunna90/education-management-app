package com.nr.student.dto;

import lombok.Data;

@Data
public class StudentResponseDto {
    private Long studentId;
    private String name;
    private Integer age;
    private String dob;
    private String gender;

    private String studentClass;
    private Integer marks;
    private String section;
    private String rollNumber;

    private String city;
    private String state;
    private String pinCode;

    private String fatherName;
    private String motherName;
}
