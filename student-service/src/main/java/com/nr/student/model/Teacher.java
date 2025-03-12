package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String fatherName;
    private String motherName;
    private String spouseName;
    private String qualification;
    private String percentageInHighestQualification;
    private String rollNumber;
    private Double experience;
    private String specializationInSubject;
    private String dateOfBirth;
    private String emailId;
    private Integer mobileNumber;
    private Integer alternativeMobileNumber;
    private String currentAddress;
    private String permanentAddress;
    private Integer children;
    @ManyToOne
    private Role designation;


}
