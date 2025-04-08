package com.nr.student.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class HealthInfo {
    private Double weight;
    private Double height;
    private String identityMarks;
    private String disability;
    private String bloodGroup;
}
