package com.nr.student.service;

import com.nr.student.dto.StudentAcademicDetailsRequest;
import com.nr.student.dto.StudentAcademicDetailsResponse;
import java.util.List;

public interface StudentAcademicDetailsService {
    List<StudentAcademicDetailsResponse> getAllStudents();
    StudentAcademicDetailsResponse getStudentById(Long id);
    StudentAcademicDetailsResponse saveStudent(StudentAcademicDetailsRequest studentDTO);
    StudentAcademicDetailsResponse updateStudent(Long id, StudentAcademicDetailsRequest studentDTO);
    void deleteStudent(Long id);

    List<StudentAcademicDetailsResponse> getStudentByStudentId(Long studentId);
}
