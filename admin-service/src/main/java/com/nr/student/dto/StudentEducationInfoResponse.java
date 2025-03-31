package com.nr.student.dto;

import lombok.Data;

@Data
public class StudentEducationInfoResponse {
    private Long id;
    private String classGrade;
    private String section;
    private String rollNumber;
    private String academicYear;
    private Double percentage;
    private String extraCurricular;
    private String remarks;
    private Long studentId;
}
