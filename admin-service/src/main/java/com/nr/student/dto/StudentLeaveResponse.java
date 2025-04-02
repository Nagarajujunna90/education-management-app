package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLeaveResponse {
    private Long id;
    private String leaveType;
    private String startDate;
    private String endDate;
    private String reason;
}
