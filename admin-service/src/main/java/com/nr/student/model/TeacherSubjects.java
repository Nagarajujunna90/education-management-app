package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teacher_subjects")
public class TeacherSubjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherPersonalInfo teacherPersonalInfo;
}