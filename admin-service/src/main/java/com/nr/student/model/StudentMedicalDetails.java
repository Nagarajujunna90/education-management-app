package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student_medical_details")
public class StudentMedicalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bloodGroup;
    private String height;
    private String weight;
    private String medicalHistory;
    private String allergies;
    private String emergencyContact;
    private String emergencyContactName;
    private String emergencyContactRelation;
    private String medicalCondition;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentPersonalInfo studentPersonalInfo;
}
