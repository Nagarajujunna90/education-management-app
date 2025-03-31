package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teacher_educations")
public class TeacherEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String highestQualification;
    private String percentageInHighestQualification;
    private String rollNumberInHighestQualification;
    private String specializationInAnySubject;
    private String certifications;

    @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false)
    private TeacherPersonalInfo teacherPersonalInfo;
}
