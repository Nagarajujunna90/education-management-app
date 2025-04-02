package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentTimetableRequest {
    private String dayOfWeek;
    private String period;
    private String subject;
}
