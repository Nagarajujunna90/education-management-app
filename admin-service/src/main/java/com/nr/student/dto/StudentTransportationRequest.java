package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentTransportationRequest {
    private String transportType;
    private String pickupLocation;
    private String dropLocation;
}
