package com.nr.student.service;

import com.nr.student.dto.StudentGradeRequest;
import com.nr.student.dto.StudentGradeResponse;
import com.nr.student.model.StudentGrade;

import java.util.List;

public interface StudentGradeService {
    StudentGradeResponse addStudentEducationInfo(StudentGradeRequest studentGradeRequest);

    StudentGradeResponse updateStudentEducationInfo(StudentGradeRequest studentGradeRequest, Long id);

    StudentGradeResponse getStudentEducationById(Long id);

    void deleteStudentEducationInfo(Long studentEducationInfoId);

    List<StudentGrade> getStudentEducationByStudentId(Long studentId);
}
