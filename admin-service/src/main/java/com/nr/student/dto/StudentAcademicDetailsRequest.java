package com.nr.student.dto;

import lombok.Data;

@Data
public class StudentAcademicDetailsRequest {
    private Long id;
    private String grade;
    private String section;
    private String rollNumber;
    private String medium;
    private String studentStatus;
    private String schoolName;
    private String schoolAddress;
    private String board;
    private Integer marks;
    private Integer totalMarks;
    private String percentage;
    private String academicYear;
    private Long studentId;
}
