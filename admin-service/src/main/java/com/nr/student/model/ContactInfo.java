package com.nr.student.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ContactInfo {
    private String mobileNumber;
    private String emergencyNumber;
    private String email;
    private String nationality;
    private String religion;
}
