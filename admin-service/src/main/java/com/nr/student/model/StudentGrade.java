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
                @UniqueConstraint(columnNames = { "class_grade","student_id","section"})
        }
)
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classGrade;  // e.g., "5th Grade", "10th Standard"
    private String section;  // e.g., "A", "B", "C"
    private String rollNumber;  // Unique within the same class & section

    @OneToOne
    @JsonBackReference
    private StudentPersonalInfo studentPersonalInfo;
}
