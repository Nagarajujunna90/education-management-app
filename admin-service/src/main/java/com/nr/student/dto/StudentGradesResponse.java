package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGradesResponse {
    private Long id;
    private String subjectName;
    private String grade;
    private String semester;
}
