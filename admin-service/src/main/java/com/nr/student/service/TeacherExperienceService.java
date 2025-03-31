package com.nr.student.service;

import com.nr.student.dto.TeacherExperienceRequest;
import com.nr.student.dto.TeacherExperienceResponse;
import com.nr.student.model.TeacherExperience;

import java.util.List;

public interface TeacherExperienceService {
    TeacherExperienceResponse saveExperience(TeacherExperienceRequest teacherExperienceRequest);
    List<TeacherExperience> getAllExperiences();
    TeacherExperienceResponse getExperienceById(Long id);
    TeacherExperienceResponse updateExperience(Long id, TeacherExperienceRequest updatedExperienceRequest);
    void deleteExperience(Long id);
}
