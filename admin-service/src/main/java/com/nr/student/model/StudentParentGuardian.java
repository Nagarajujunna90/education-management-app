package com.nr.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private StudentPersonalInfo studentPersonalInfo;
    private String name;
    private String qualification;
    private String occupation;
    private int age;
    private String email;
    private String mobileNumber;
    private String relationType;
}