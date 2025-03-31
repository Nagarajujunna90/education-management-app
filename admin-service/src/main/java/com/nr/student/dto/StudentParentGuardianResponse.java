package com.nr.student.dto;
import lombok.Data;

@Data
public class StudentParentGuardianResponse {
    private Long id;  // Instead of StudentPersonalInfo object
    private String role;  // "Father", "Mother", or "Guardian"
    private String name;
    private String qualification;
    private String occupation;
    private int age;
    private String email;
    private String mobileNumber;
    private String relationshipWithStudent;
}

