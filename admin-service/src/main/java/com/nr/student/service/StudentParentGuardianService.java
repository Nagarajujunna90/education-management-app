package com.nr.student.service;

import com.nr.student.dto.StudentParentGuardianRequest;
import com.nr.student.dto.StudentParentGuardianResponse;
import com.nr.student.model.StudentParentGuardian;

import java.util.List;

public interface StudentParentGuardianService {
    StudentParentGuardianResponse createParentGuardian(StudentParentGuardianRequest studentParentGuardianRequest);
    StudentParentGuardianResponse updateParentGuardian(Long id, StudentParentGuardianRequest studentParentGuardianRequest);
    StudentParentGuardianResponse getParentGuardianById(Long id);
    List<StudentParentGuardian> getAllParentGuardians();
    List<StudentParentGuardian> getParentGuardiansByStudentId(Long studentId);
    void deleteParentGuardian(Long id);
}
