package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDocumentsResponse {
    private Long id;
    private String documentType;
    private String documentUrl;
    private String documentDate;
}
