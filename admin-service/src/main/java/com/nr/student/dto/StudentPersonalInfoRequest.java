package com.nr.student.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentPersonalInfoRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String motherName;
    private String fatherName;
    private String guardianName;
    private String gender;
    private int age;
    private LocalDate dateOfBirth;
    private String nationality;
    private String religion;
    private String mobileNumber;
    private String emergencyNumber;
    private Double weight;
    private Double height;
    private String identityMarks;
    private String disability;
    private String bloodGroup;
    private List<String> hobbies;
}
