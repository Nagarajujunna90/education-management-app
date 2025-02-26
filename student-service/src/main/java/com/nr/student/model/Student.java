package com.nr.student.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nr.student.dto.StudentDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@Data
@Table
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String fatherName;
    private String motherName;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,targetEntity = Address.class)
    @JsonManagedReference
    private List<Address> addressList;
    private Integer age;
    private LocalDate dateOfBirth;
    private Integer weight;
    private String[] hobbies;


    public Student(StudentDto studentDto) {
        this.name = studentDto.getName();
        this.fatherName = studentDto.getFatherName();
        this.motherName = studentDto.getMotherName();
        this.age = studentDto.getAge();
        this.dateOfBirth = studentDto.getDateOfBirth();
        this.weight = studentDto.getWeight();
        this.hobbies = studentDto.getHobbies();
        this.addressList=studentDto.getAddressList();
    }
}
