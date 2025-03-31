package com.nr.student.service;

import com.nr.student.dto.TeacherPersonalInfoRequest;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.TeacherPersonalInfo;
import com.nr.student.repo.TeacherPersonalInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherPersonalInfoRepository teacherPersonalInfoRepository;
    private AuthServiceClient authServiceClient;

    public TeacherServiceImpl(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    @Override
    public TeacherPersonalInfo addTeacher(TeacherPersonalInfoRequest teacherPersonalInfoRequest) {
        try {
            TeacherPersonalInfo teacherPersonalInfo = new TeacherPersonalInfo();
            BeanUtils.copyProperties(teacherPersonalInfoRequest, teacherPersonalInfo);
            Long userId = authServiceClient.getUserIdByUserName(teacherPersonalInfoRequest.getUserName());
            teacherPersonalInfo.setRegistrationId(userId);
            return teacherPersonalInfoRepository.save(teacherPersonalInfo);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DataIntegrityViolationException("Teacher username/details already registered");
        }
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        teacherPersonalInfoRepository.deleteById(teacherId);
    }

    @Override
    public TeacherPersonalInfo updateTeacher(TeacherPersonalInfoRequest teacherPersonalInfoRequest, Long teacherId) {
        try {
            TeacherPersonalInfo teacherPersonalInfo = teacherPersonalInfoRepository
                    .findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Teacher details not found"));
            if (Optional.ofNullable(teacherPersonalInfo).isPresent()) {
                BeanUtils.copyProperties(teacherPersonalInfoRequest, teacherPersonalInfo);
                return teacherPersonalInfoRepository.save(teacherPersonalInfo);
            }
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DataIntegrityViolationException("Teacher username/details already registered");
        }
        return null;
    }

    @Override
    public TeacherPersonalInfo getTeacherById(Long teacherId) {
        return teacherPersonalInfoRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Teacher details not found"));
    }

    @Override
    public List<TeacherPersonalInfo> getAllTeachers() {
        return teacherPersonalInfoRepository.findAll();
    }
}
