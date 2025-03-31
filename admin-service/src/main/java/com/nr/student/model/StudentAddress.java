package com.nr.student.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "student_addresses")
@Data
public class StudentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentPersonalInfo studentPersonalInfo;
    private String addressType; // "Permanent" or "Present"
    private String flatNumber;
    private String street;
    private String area;
    private String district;
    private String state;
    private String country;

}
