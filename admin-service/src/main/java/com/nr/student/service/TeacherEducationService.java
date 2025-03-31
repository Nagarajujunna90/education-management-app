package com.nr.student.service;

import com.nr.student.dto.TeacherEducationRequest;
import com.nr.student.dto.TeacherEducationResponse;
import com.nr.student.model.TeacherEducation;

import java.util.List;

public interface TeacherEducationService {
    TeacherEducationResponse saveEducation(TeacherEducationRequest educationRequest);

    List<TeacherEducation> getAllEducations();

    TeacherEducationResponse getEducationById(Long id);

    TeacherEducationResponse updateEducation(Long id, TeacherEducationRequest updatedEducationRequest);

    void deleteEducation(Long id);
}
