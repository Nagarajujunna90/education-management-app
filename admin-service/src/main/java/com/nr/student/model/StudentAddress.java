package com.nr.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private StudentPersonalInfo studentPersonalInfo;
    private String addressType; // "Permanent" or "Present"
    private String houseNumber;
    private String area;
    private String city;
    private String state;
    private String country;
    private String zipCode;

}
