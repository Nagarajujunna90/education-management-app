package com.nr.student.service;

import com.nr.student.dto.TeacherCertificationRequest;
import com.nr.student.dto.TeacherCertificationResponse;
import java.util.List;

public interface TeacherCertificationService {
    TeacherCertificationResponse createCertification(TeacherCertificationRequest request);
    TeacherCertificationResponse getCertificationById(Long id);
    List<TeacherCertificationResponse> getAllCertifications();
    void deleteCertification(Long id);
}