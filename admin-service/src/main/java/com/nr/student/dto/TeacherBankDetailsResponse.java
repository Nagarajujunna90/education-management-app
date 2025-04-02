package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherBankDetailsResponse {
    private Long id;
    private String bankName;
    private String accountNumber;
    private String ifscCode;
    private String branchName;
    private Long teacherId;
}

