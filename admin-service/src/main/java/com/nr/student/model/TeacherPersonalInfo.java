package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "teacher_personal_infos")
public class TeacherPersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    @Column(nullable = false, unique = true)
    private Long registrationId;
    private String userName;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String spouseName;
    private String maritalStatus;
    private Integer children;
    private String dateOfBirth;
    private String disability;
    private String email;
    private Integer mobileNumber;
    private Integer alternativeMobileNumber;
    private Integer emergencyContactNumber;


    @OneToMany(mappedBy = "teacherPersonalInfo", cascade = CascadeType.ALL)
    private List<TeacherEducation> education;

    @OneToMany(mappedBy = "teacherPersonalInfo", cascade = CascadeType.ALL)
    private List<TeacherExperience> experience;

    @OneToMany(mappedBy = "teacherPersonalInfo", cascade = CascadeType.ALL)
    private List<TeacherAddress> address;

    @OneToMany(mappedBy = "teacherPersonalInfo", cascade = CascadeType.ALL)
    private List<TeacherDocuments> documents;
}
