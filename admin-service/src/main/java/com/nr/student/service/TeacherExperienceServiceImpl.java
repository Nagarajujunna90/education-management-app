package com.nr.student.service;

import com.nr.student.dto.TeacherExperienceRequest;
import com.nr.student.dto.TeacherExperienceResponse;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.TeacherExperience;
import com.nr.student.model.TeacherPersonalInfo;
import com.nr.student.repo.TeacherExperienceRepository;
import com.nr.student.repo.TeacherPersonalInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherExperienceServiceImpl implements TeacherExperienceService {

    @Autowired
    private TeacherExperienceRepository experienceRepository;

    @Autowired
    private TeacherPersonalInfoRepository personalInfoRepository;

    @Override
    public TeacherExperienceResponse saveExperience(TeacherExperienceRequest experience) {
        TeacherPersonalInfo teacherPersonalInfo = personalInfoRepository.findById(experience.getTeacherId()).orElseThrow(() -> new ResourceNotFoundException("Teacher not found with ID: " + experience.getTeacherId()));
        TeacherExperience teacherExperience = new TeacherExperience();
        BeanUtils.copyProperties(experience, teacherExperience);
        teacherExperience.setTeacherPersonalInfo(teacherPersonalInfo);
        TeacherExperience savedExperience = experienceRepository.save(teacherExperience);
        TeacherExperienceResponse response = new TeacherExperienceResponse();
        BeanUtils.copyProperties(savedExperience, response);
        return response;
    }

    @Override
    public List<TeacherExperience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public TeacherExperienceResponse getExperienceById(Long id) {
        TeacherExperience teacherExperience = experienceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Experience record not found with ID: " + id));
        TeacherExperienceResponse response = new TeacherExperienceResponse();
        BeanUtils.copyProperties(teacherExperience, response);
        return response;
    }

    @Override
    public TeacherExperienceResponse updateExperience(Long id, TeacherExperienceRequest updatedExperienceRequest) {
        TeacherExperience teacherExperience = experienceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Experience record not found with ID: " + id));
        BeanUtils.copyProperties(updatedExperienceRequest, teacherExperience);
        TeacherExperience updatedExperience = experienceRepository.save(teacherExperience);
        TeacherExperienceResponse response = new TeacherExperienceResponse();
        BeanUtils.copyProperties(updatedExperience, response);
        return response;
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}
