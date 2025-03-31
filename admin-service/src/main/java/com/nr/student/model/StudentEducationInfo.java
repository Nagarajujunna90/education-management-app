package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "student_educations",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = { "class_grade", "section"}), // Roll number is unique within the class & section
                @UniqueConstraint(columnNames = { "student_id", "academic_year" }) // Student can have only one entry per academic year
        }
)
public class StudentEducationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_grade", nullable = false)
    private String classGrade;  // e.g., "5th Grade", "10th Standard"

    @Column(name = "section", nullable = false)
    private String section;  // e.g., "A", "B", "C"

    @Column(name = "roll_number", nullable = false)
    private String rollNumber;  // Unique within the same class & section

    @Column(name = "academic_year", nullable = false)
    private String academicYear;  // e.g., "2024-2025"

    @Column(name = "percentage")
    private Double percentage;  // Optional, for exam results

    @Column(name = "extra_curricular")
    private String extraCurricular;  // e.g., "Sports, Music"

    @Column(name = "remarks")
    private String remarks;  // Additional notes about the student

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentPersonalInfo studentPersonalInfo;
}
