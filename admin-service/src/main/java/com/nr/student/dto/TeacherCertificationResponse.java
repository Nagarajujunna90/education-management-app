package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherCertificationResponse {
    private Long id;
    private String certificationName;
    private String certificationAuthority;
    private String certificationDate;
    private Long teacherId;
}