package com.nr.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;
    private String houseNumber;
    private String street;
    private String area;
    private String village;
    private String mandal;
    private String district;
    private String state;
    private String country;
    private Integer pinCode;
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "std_id",referencedColumnName = "id")
    @JsonBackReference
    private Student student;
}
