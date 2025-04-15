package com.nr.student.service;

import com.nr.student.model.StudentMedicalDetails;
import java.util.List;

public interface StudentMedicalInfoService {
    StudentMedicalDetails saveStudentMedicalInfo(StudentMedicalDetails studentMedicalDetails);
    List<StudentMedicalDetails> getAllStudentMedicalInfo();
    StudentMedicalDetails getStudentMedicalInfoById(Long id);
    void deleteStudentMedicalInfo(Long id);
}
