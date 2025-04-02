package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student_medical_info")
public class StudentMedicalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicalCondition;
    private String requiredMedication;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentPersonalInfo studentPersonalInfo;
}
