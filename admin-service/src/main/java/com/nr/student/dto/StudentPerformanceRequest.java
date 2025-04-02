package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentPerformanceRequest {
    private String subject;
    private String performanceRemarks;
    private String grade;
}
