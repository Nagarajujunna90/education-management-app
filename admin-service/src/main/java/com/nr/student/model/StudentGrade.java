package com.nr.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "student_grade",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"class_grade", "student_id", "section"})
        }
)
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;
    private String grade;
    private String section;
    private String rollNumber;
    private String academicYear;
    private String studentStatus; // "active" or "inactive"

    @OneToOne
    @JsonBackReference
    private StudentPersonalInfo studentPersonalInfo;
}
