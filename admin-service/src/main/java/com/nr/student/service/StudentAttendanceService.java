package com.nr.student.service;

import com.nr.student.model.StudentAttendance;
import java.util.List;

public interface StudentAttendanceService {
    StudentAttendance saveStudentAttendance(StudentAttendance studentAttendance);
    List<StudentAttendance> getAllStudentAttendance();
    StudentAttendance getStudentAttendanceById(Long id);
    void deleteStudentAttendance(Long id);
}
