package com.nr.student.service;

import com.nr.student.model.StudentMedicalInfo;
import java.util.List;

public interface StudentMedicalInfoService {
    StudentMedicalInfo saveStudentMedicalInfo(StudentMedicalInfo studentMedicalInfo);
    List<StudentMedicalInfo> getAllStudentMedicalInfo();
    StudentMedicalInfo getStudentMedicalInfoById(Long id);
    void deleteStudentMedicalInfo(Long id);
}
