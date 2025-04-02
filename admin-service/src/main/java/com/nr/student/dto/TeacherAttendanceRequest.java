package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherAttendanceRequest {
    private String date;
    private Boolean isPresent;
    private Long teacherId;
}
