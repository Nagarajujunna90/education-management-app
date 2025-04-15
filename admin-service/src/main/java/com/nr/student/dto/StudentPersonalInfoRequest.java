package com.nr.student.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentPersonalInfoRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // ✅ Helps when using Request Parameters
    private LocalDate dateOfBirth;
    private Long phoneNumber;
    private String profileImage;
    private String identityMarks;
    private String emailId;

}
