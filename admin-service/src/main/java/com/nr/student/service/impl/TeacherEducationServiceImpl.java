package com.nr.student.service.impl;

import com.nr.student.dto.TeacherEducationRequest;
import com.nr.student.dto.TeacherEducationResponse;
import com.nr.student.model.TeacherEducation;
import com.nr.student.model.TeacherPersonalInfo;
import com.nr.student.repository.TeacherEducationRepository;
import com.nr.student.repository.TeacherPersonalInfoRepository;
import com.nr.student.service.TeacherEducationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherEducationServiceImpl implements TeacherEducationService {

    @Autowired
    private TeacherEducationRepository educationRepository;

    @Autowired
    private TeacherPersonalInfoRepository personalInfoRepository;

    @Override
    public TeacherEducationResponse saveEducation(TeacherEducationRequest educationRequest) {
        TeacherPersonalInfo teacherPersonalInfo = personalInfoRepository.findById(educationRequest.getTeacherId()).orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + educationRequest.getTeacherId()));
        TeacherEducation teacherEducation = new TeacherEducation();
        BeanUtils.copyProperties(educationRequest, teacherEducation);
        teacherEducation.setTeacherPersonalInfo(teacherPersonalInfo);
        TeacherEducation education = educationRepository.save(teacherEducation);
        TeacherEducationResponse response = new TeacherEducationResponse();
        BeanUtils.copyProperties(education, response);
        return response;
    }

    @Override
    public List<TeacherEducation> getAllEducations() {
        return educationRepository.findAll();
    }

    @Override
    public TeacherEducationResponse getEducationById(Long id) {
        TeacherEducation education = educationRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher Education not found with ID: " + id));
        TeacherEducationResponse response = new TeacherEducationResponse();
        BeanUtils.copyProperties(education, response);
        return response;
    }

    @Override
    public TeacherEducationResponse updateEducation(Long id, TeacherEducationRequest updatedEducationRequest) {
        TeacherEducation teacherEducation = educationRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher Education not found with ID: " + id));
        BeanUtils.copyProperties(updatedEducationRequest, teacherEducation);
        TeacherEducation education = educationRepository.save(teacherEducation);
        TeacherEducationResponse response = new TeacherEducationResponse();
        BeanUtils.copyProperties(education, response);
        return response;
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
