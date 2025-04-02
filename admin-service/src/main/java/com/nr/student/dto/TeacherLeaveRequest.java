package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherLeaveRequest {
    private String leaveType;
    private String startDate;
    private String endDate;
    private String reason;
    private Long teacherId;
}
