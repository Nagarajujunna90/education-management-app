package com.nr.student.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ContactInfo {
    private String mobileNumber;
    private String emergencyContact;
    private String emailId;
    private String relationship;
}
