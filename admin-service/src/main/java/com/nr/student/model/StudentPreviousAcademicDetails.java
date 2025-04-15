package com.nr.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_academic_details",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"student_id", "academic_year", "grade", "section"})
        })
@Data
public class StudentPreviousAcademicDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String grade;
    private String section;
    private String rollNumber;
    private String medium;
    private String studentStatus;
    private String schoolName;
    private String schoolAddress;
    private String board;
    private Integer marks;
    private Integer totalMarks;
    private String percentage;
    private String academicYear;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonBackReference
    private StudentPersonalInfo studentPersonalInfo;
}
