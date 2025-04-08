package com.nr.student.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "student_personal_info")
public class StudentPersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(unique = true, nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
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


    @Embedded
    private ContactInfo contactInfo;
    @Embedded
    private HealthInfo healthInfo;
    private List<String> hobbies;
    private String profileImage;

    @JsonManagedReference
    @OneToMany(mappedBy = "studentPersonalInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentAddress> studentAddresses;

    @OneToMany(mappedBy = "studentPersonalInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<StudentParentGuardian> studentParentGuardians;

    @OneToOne(mappedBy = "studentPersonalInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private StudentGrade studentGrade;

    @OneToOne(mappedBy = "studentPersonalInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private StudentDemographic studentDemographic;

}

