package com.nr.student.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "student_personal_infos")
public class StudentPersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(unique = true,nullable = false)
    private Long registrationId;
    private String firstName;
    private String lastName;
    private String motherName;
    private String fatherName;
    private String guardianName;
    private String gender;
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String nationality;
    private String religion;
    private String mobileNumber;
    private String emergencyNumber;
    private Double weight;
    private Double height;
    private String identityMarks;
    private String disability;
    private String bloodGroup;
    private List<String> hobbies;

    @OneToMany(mappedBy = "studentPersonalInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentAddress> studentAddresses;

    @OneToMany(mappedBy = "studentPersonalInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentParentGuardian> studentParentGuardians;

    @OneToMany(mappedBy = "studentPersonalInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentEducationInfo> studentEducationInfos;

}

