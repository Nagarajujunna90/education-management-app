package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherBankDetailsRequest {
    private String bankName;
    private String accountNumber;
    private String ifscCode;
    private String branchName;
    private Long teacherId;
}
