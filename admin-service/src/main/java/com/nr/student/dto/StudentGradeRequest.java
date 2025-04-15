package com.nr.student.dto;

import lombok.Data;

@Data
public class StudentGradeRequest {
    private String grade;
    private String section;
    private String rollNumber;
    private String academicYear;
    private Long studentId;
    private String studentStatus; // "active" or "inactive"
}
