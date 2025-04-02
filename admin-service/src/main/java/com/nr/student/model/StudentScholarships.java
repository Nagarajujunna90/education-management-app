package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student_scholarships")
public class StudentScholarships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scholarshipName;
    private Double scholarshipAmount;
    private String awardDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentPersonalInfo studentPersonalInfo;
}
