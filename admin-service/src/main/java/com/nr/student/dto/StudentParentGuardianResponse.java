package com.nr.student.dto;
import lombok.Data;

@Data
public class StudentParentGuardianResponse {
    private Long guardianId;  // Instead of StudentPersonalInfo object
    private String name;
    private String qualification;
    private String occupation;
    private int age;
    private String emailId;
    private String phoneNumber;
    private String relationType;
}

