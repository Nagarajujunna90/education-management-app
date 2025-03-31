package com.nr.student.dto;

import lombok.Data;

@Data
public class TeacherExperienceResponse {
    private Long id;
    private Double teachingExperience;
    private String anyOtherExperience;
    private Double otherExperienceInYears;

    private Long teacherId;
}
