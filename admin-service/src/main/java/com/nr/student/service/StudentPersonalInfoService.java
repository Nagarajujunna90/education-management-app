package com.nr.student.service;

import com.nr.student.dto.StudentPersonalInfoRequest;
import com.nr.student.dto.StudentPersonalInfoResponse;
import com.nr.student.model.StudentPersonalInfo;

import java.util.List;

public interface StudentPersonalInfoService {

    StudentPersonalInfoResponse addStudent(StudentPersonalInfoRequest studentPersonalInfoRequest) ;

    StudentPersonalInfoResponse updateStudent(StudentPersonalInfoRequest studentPersonalInfoRequest, Long studentId);

    void deleteStudentById(Long studentId);

    StudentPersonalInfoResponse getStudentById(Long studentId);

    List<StudentPersonalInfo> getAllStudents();
}
