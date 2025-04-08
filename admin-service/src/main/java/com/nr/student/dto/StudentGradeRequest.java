package com.nr.student.dto;

import lombok.Data;

@Data
public class StudentGradeRequest {
    private String classGrade;  // e.g., "5th Grade", "10th Standard"
    private String section;  // e.g., "A", "B", "C"
    private String rollNumber;  // Unique roll number for the student
//    private String academicYear;  // e.g., "2024-2025"
//    private Double percentage;  // Optional, for exam results
//    private String extraCurricular;  // e.g., "Sports, Music"
//    private String remarks;  // Additional notes about the student
    private Long studentId;  // Foreign key to StudentPersonalInfo
}
