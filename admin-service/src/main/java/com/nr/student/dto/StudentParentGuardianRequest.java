package com.nr.student.dto;
import lombok.Data;

@Data
public class StudentParentGuardianRequest {
    private String role;  // "Father", "Mother", or "Guardian"
    private String name;
    private String qualification;
    private String occupation;
    private int age;
    private String email;
    private String mobileNumber;
    private String relationshipWithStudent;
    private Long studentId;  // Instead of StudentPersonalInfo object

}

