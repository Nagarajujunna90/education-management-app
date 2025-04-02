package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student_attendance")
public class StudentAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Boolean isPresent;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentPersonalInfo studentPersonalInfo;
}
