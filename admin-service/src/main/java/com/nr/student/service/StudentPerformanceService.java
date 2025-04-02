package com.nr.student.service;

import com.nr.student.model.StudentPerformance;
import java.util.List;

public interface StudentPerformanceService {
    StudentPerformance saveStudentPerformance(StudentPerformance studentPerformance);
    List<StudentPerformance> getAllStudentPerformance();
    StudentPerformance getStudentPerformanceById(Long id);
    void deleteStudentPerformance(Long id);
}
