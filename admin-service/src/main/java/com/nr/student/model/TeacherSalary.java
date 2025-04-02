package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teacher_salary")
public class TeacherSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double salaryAmount;
    private String paymentDate;
    private String deductions;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherPersonalInfo teacherPersonalInfo;
}