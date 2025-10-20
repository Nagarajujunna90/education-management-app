package com.nr.student.dto;

import com.nr.student.model.StudentPreviousAcademicDetails;
import lombok.Data;

import java.util.List;

@Data
public class StudentCompositeRequest {
    private StudentPersonalInfoRequest personalInfo;
    private List<StudentParentGuardianRequest> parentGuardians;
    private List<StudentPreviousAcademicDetails> academics;
    private List<StudentAddressRequest> addresses;
    private List<StudentGradeRequest> grades;
    private List<StudentDocumentsRequest> documents;
}