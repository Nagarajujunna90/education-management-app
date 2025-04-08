package com.nr.student.dto;

import lombok.Data;

@Data
public class StudentFilterRequest {
    private String name;
    private String gender;
    private String studentClass;
    private Integer age;
}
