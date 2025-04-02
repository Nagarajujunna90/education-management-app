package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherCertificationRequest {
    private String certificationName;
    private String certificationAuthority;
    private String certificationDate;
    private Long teacherId;
}
