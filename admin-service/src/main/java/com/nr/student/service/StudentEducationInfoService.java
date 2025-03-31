package com.nr.student.service;

import com.nr.student.dto.StudentEducationInfoRequest;
import com.nr.student.dto.StudentEducationInfoResponse;
import com.nr.student.model.StudentEducationInfo;

import java.util.List;

public interface StudentEducationInfoService {
    StudentEducationInfoResponse addStudentEducationInfo(StudentEducationInfoRequest studentEducationInfoRequest);

    StudentEducationInfoResponse updateStudentEducationInfo(StudentEducationInfoRequest studentEducationInfoRequest, Long id);

    StudentEducationInfoResponse getStudentEducationById(Long id);

    void deleteStudentEducationInfo(Long studentEducationInfoId);

    List<StudentEducationInfo> getStudentEducationByStudentId(Long studentId);
}
