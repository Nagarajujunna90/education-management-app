package com.nr.student.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentPersonalInfoResponse {
    private Long studentId;
    private String userName;
    private String firstName;
    private String lastName;
    private String profileImage;
    private Long phoneNumber;
    private String gender;
    private int age;
    private LocalDate dateOfBirth;
    private String identityMarks;
    private List<String> hobbies;
}
