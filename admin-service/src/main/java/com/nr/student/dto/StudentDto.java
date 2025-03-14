package com.nr.student.dto;

import com.nr.student.model.Address;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentDto {
    private String name;
    private String fatherName;
    private String motherName;
    private List<Address> addressList;
    private Integer age;
    private LocalDate dateOfBirth;
    private Integer weight;
    private String[] hobbies;
}
