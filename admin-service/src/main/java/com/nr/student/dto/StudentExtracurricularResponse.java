package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentExtracurricularResponse {
    private Long id;
    private String activityName;
    private String description;
    private String startDate;
    private String endDate;
}
