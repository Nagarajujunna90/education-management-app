package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAttendanceRequest {
    private String date;
    private boolean isPresent;
    private String remarks;
}
