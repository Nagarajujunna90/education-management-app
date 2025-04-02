package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentFeeDetailsResponse {
    private Long id;
    private double feeAmount;
    private String dueDate;
    private String paymentStatus;
}
