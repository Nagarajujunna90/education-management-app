package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "teacher_addresses",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"teacher_id", "addressType"})
        })
@Data
public class TeacherAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String addressType; // "Permanent" or "Present"
    private String flatNumber;
    private String street;
    private String area;
    private String district;
    private String state;
    private String country;
    private String pinCode;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherPersonalInfo teacherPersonalInfo;

}
