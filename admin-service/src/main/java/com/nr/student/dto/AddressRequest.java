package com.nr.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressRequest {
    @NotBlank(message = "Address type is required")
    @Pattern(regexp = "^(permanent|present)$", message = "Address type must be either 'permanent' or 'present'")
    private String addressType;  // "present" or "permanent"
    private String flatNumber;
    private String street;
    private String area;
    private String district;
    private String state;
    private String country;
    private String pinCode;
    private Long studentId;
}
