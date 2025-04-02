package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentMedicalInfoRequest {
    private String medicalCondition;
    private String treatment;
    private String medication;
    private String doctorName;
}
