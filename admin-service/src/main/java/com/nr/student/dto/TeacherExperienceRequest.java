package com.nr.student.dto;

import lombok.Data;

@Data
public class TeacherExperienceRequest {
    private Double teachingExperience;
    private String anyOtherExperience;
    private Double otherExperienceInYears;

    private Long teacherId;

}
