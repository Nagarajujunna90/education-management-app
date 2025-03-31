package com.nr.student.dto;

import lombok.Data;

@Data
public class TeacherEducationRequest {
    private String highestQualification;
    private String percentageInHighestQualification;
    private String rollNumberInHighestQualification;
    private String specializationInAnySubject;
    private String certifications;
    private Long teacherId; // Instead of TeacherPersonalInfo object
}
