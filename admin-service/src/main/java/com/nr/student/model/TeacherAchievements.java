package com.nr.student.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teacher_achievements")
public class TeacherAchievements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String achievement;
    private String date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherPersonalInfo teacherPersonalInfo;
}
