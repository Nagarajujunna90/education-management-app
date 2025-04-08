package com.nr.student.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_academic_details")
@Data
public class StudentAcademicDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentPersonalInfo student;

    private String grade;
    private String section;
    private String rollNumber;
    private String studentStatus;
    private int year;
}
