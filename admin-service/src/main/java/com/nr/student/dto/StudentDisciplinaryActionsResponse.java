package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDisciplinaryActionsResponse {
    private Long id;
    private String action;
    private String date;
    private String description;
}
