package com.nr.student.service.impl;

import com.nr.student.dto.TeacherCertificationRequest;
import com.nr.student.dto.TeacherCertificationResponse;
import com.nr.student.model.TeacherCertification;
import com.nr.student.model.TeacherPersonalInfo;

import com.nr.student.repository.TeacherCertificationRepository;
import com.nr.student.repository.TeacherPersonalInfoRepository;
import com.nr.student.service.TeacherCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherCertificationServiceImpl implements TeacherCertificationService {

    @Autowired
    private TeacherCertificationRepository teacherCertificationRepository;

    @Autowired
    private TeacherPersonalInfoRepository teacherPersonalInfoRepository;

    public TeacherCertificationServiceImpl() {
    }

    @Override
    public TeacherCertificationResponse createCertification(TeacherCertificationRequest request) {
        TeacherPersonalInfo teacher = teacherPersonalInfoRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        TeacherCertification certification = new TeacherCertification();
        certification.setCertificationName(request.getCertificationName());
        certification.setCertificationAuthority(request.getCertificationAuthority());
        certification.setCertificationDate(request.getCertificationDate());
        certification.setTeacherPersonalInfo(teacher);

        TeacherCertification savedCertification = teacherCertificationRepository.save(certification);
        return mapToResponse(savedCertification);
    }

    @Override
    public TeacherCertificationResponse getCertificationById(Long id) {
        TeacherCertification certification = teacherCertificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Certification not found"));
        return mapToResponse(certification);
    }

    @Override
    public List<TeacherCertificationResponse> getAllCertifications() {
        List<TeacherCertification> certifications = teacherCertificationRepository.findAll();
        return certifications.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteCertification(Long id) {
        teacherCertificationRepository.deleteById(id);
    }

    private TeacherCertificationResponse mapToResponse(TeacherCertification certification) {
        TeacherCertificationResponse response = new TeacherCertificationResponse();
        response.setId(certification.getId());
        response.setCertificationName(certification.getCertificationName());
        response.setCertificationAuthority(certification.getCertificationAuthority());
        response.setCertificationDate(certification.getCertificationDate());
       // response.setTeacherId(certification.getTeacherPersonalInfo().getTeacherId());
        return response;
    }
}
