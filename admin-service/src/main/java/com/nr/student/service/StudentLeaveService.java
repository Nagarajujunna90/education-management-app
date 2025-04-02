package com.nr.student.service;

import com.nr.student.model.StudentLeave;
import java.util.List;

public interface StudentLeaveService {
    StudentLeave saveStudentLeave(StudentLeave studentLeave);
    List<StudentLeave> getAllStudentLeave();
    StudentLeave getStudentLeaveById(Long id);
    void deleteStudentLeave(Long id);
}
