package com.nr.student.dto;

import lombok.Data;

@Data
public class TeacherEducationResponse {
    private Long id;
    private String highestQualification;
    private String percentageInHighestQualification;
    private String rollNumberInHighestQualification;
    private String specializationInAnySubject;
    private String certifications;
}
