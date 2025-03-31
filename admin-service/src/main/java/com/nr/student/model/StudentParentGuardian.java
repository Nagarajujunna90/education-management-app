package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_parent_guardian_details",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = { "role", "student_id"}) // Student can have only one entry per academic year
})
public class StudentParentGuardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentPersonalInfo studentPersonalInfo;
    private String role; // "Father", "Mother", or "Guardian"
    private String name;
    private String qualification;
    private String occupation;
    private int age;
    private String email;
    private String mobileNumber;
    private String relationshipWithStudent;
}