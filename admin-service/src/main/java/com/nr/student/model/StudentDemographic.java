package com.nr.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "student_demographic")
@Entity
@Data
public class StudentDemographic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long demographicId;
    private String religion;
    private String nationality;
    private String caste;
    private String subCaste;
    private String motherTongue;
    @OneToOne
    @JsonBackReference
    private StudentPersonalInfo studentPersonalInfo;
}
