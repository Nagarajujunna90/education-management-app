package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teacher_feedback")
public class TeacherFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feedback;
    private String givenBy;
    private String date;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherPersonalInfo teacherPersonalInfo;
}
