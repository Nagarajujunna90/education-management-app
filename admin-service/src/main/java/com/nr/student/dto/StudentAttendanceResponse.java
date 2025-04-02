package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAttendanceResponse {
    private Long id;
    private String date;
    private boolean isPresent;
    private String remarks;
}
