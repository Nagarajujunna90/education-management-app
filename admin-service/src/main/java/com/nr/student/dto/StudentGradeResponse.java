package com.nr.student.dto;

import lombok.Data;

@Data
public class StudentGradeResponse {
    private Long gradeId;
    private String grade;
    private String section;
    private String rollNumber;
    private String academicYear;
    private String studentStatus; // "active" or "inactive"
    private Long studentId;
}
