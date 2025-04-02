package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teacher_schedule")
public class TeacherSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scheduleDate;
    private String startTime;
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherPersonalInfo teacherPersonalInfo;
}