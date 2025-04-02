package com.nr.student.service.impl;

import com.nr.student.dto.StudentEducationInfoRequest;
import com.nr.student.dto.StudentEducationInfoResponse;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.StudentEducationInfo;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentEducationInfoRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import com.nr.student.service.StudentEducationInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentEducationInfoServiceImpl implements StudentEducationInfoService {

    private StudentEducationInfoRepository studentEducationInfoRepository;

    private StudentPersonalInfoRepository studentPersonalInfoRepository;

    public StudentEducationInfoServiceImpl(StudentEducationInfoRepository studentEducationInfoRepository, StudentPersonalInfoRepository studentPersonalInfoRepository) {
        this.studentEducationInfoRepository = studentEducationInfoRepository;
        this.studentPersonalInfoRepository = studentPersonalInfoRepository;
    }

    @Override
    public StudentEducationInfoResponse addStudentEducationInfo(StudentEducationInfoRequest studentEducationInfoRequest) {
        StudentEducationInfoResponse studentEducationInfoResponse = new StudentEducationInfoResponse();
        try {
            // Fetch student info or throw exception if not found
            StudentPersonalInfo studentPersonalInfo = studentPersonalInfoRepository
                    .findById(studentEducationInfoRequest.getStudentId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Student not found with ID: " + studentEducationInfoRequest.getStudentId()));
            // Create a new StudentEducationInfo object and copy properties
            StudentEducationInfo studentEducationInfo = new StudentEducationInfo();
            BeanUtils.copyProperties(studentEducationInfoRequest, studentEducationInfo);
            studentEducationInfo.setStudentPersonalInfo(studentPersonalInfo);

            // Save and return
            StudentEducationInfo educationInfo = studentEducationInfoRepository.save(studentEducationInfo);
            BeanUtils.copyProperties(educationInfo, studentEducationInfoResponse);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data already exists for this class, section, and academic year.");
        }
        return studentEducationInfoResponse;
    }

    @Override
    public StudentEducationInfoResponse updateStudentEducationInfo(StudentEducationInfoRequest studentEducationInfoRequest, Long id) {
        StudentEducationInfo studentEducationInfo = studentEducationInfoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student Education Info not found"));
        StudentEducationInfoResponse studentEducationInfoResponse = new StudentEducationInfoResponse();
        if (Optional.ofNullable(studentEducationInfo).isPresent()) {
            BeanUtils.copyProperties(studentEducationInfoRequest, studentEducationInfo);
            StudentEducationInfo saved = studentEducationInfoRepository.save(studentEducationInfo);
            BeanUtils.copyProperties(saved, studentEducationInfoResponse);
        }
        return studentEducationInfoResponse;
    }

    @Override
    public StudentEducationInfoResponse getStudentEducationById(Long id) {
        StudentEducationInfo studentEducationInfo = studentEducationInfoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student Education Info not found"));
        StudentEducationInfoResponse studentEducationInfoResponse = new StudentEducationInfoResponse();
        BeanUtils.copyProperties(studentEducationInfo, studentEducationInfoResponse);
        return studentEducationInfoResponse;
    }

    @Override
    public void deleteStudentEducationInfo(Long studentEducationInfoId) {
        studentEducationInfoRepository.deleteById(studentEducationInfoId);
    }

    @Override
    public List<StudentEducationInfo> getStudentEducationByStudentId(Long studentId) {
        return studentEducationInfoRepository.findByStudentPersonalInfo_StudentId(studentId);
    }


}
