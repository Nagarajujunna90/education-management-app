package com.nr.student.dto;

import lombok.Data;

@Data
public class StudentAcademicDetailsResponse {
    private Long id;
    private Long studentId;
    private String grade;
    private String section;
    private String rollNumber;
    private String studentStatus;
    private int year;
}
