package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student_sport")
public class StudentSport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sportName;
    private String level;
    private String achievements;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentPersonalInfo studentPersonalInfo;
}
