package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentTimetableResponse {
    private Long id;
    private String dayOfWeek;
    private String period;
    private String subject;
}
