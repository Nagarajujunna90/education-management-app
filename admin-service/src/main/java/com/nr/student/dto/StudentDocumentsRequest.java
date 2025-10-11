package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDocumentsRequest {
    private String documentType;
    private String documentUrl;
    private String documentDate;
    private Long studentId;
}
