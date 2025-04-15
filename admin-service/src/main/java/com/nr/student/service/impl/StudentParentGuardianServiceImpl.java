package com.nr.student.service.impl;

import com.nr.student.dto.StudentParentGuardianRequest;
import com.nr.student.dto.StudentParentGuardianResponse;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.StudentParentGuardian;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentParentGuardianRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import com.nr.student.service.StudentParentGuardianService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentParentGuardianServiceImpl implements StudentParentGuardianService {

    @Autowired
    private StudentParentGuardianRepository studentParentGuardianRepository;
    @Autowired
    private StudentPersonalInfoRepository studentPersonalInfoRepository;


    @Override
    public StudentParentGuardianResponse createParentGuardian(StudentParentGuardianRequest studentParentGuardianRequest) {
        System.out.println(studentParentGuardianRequest);
        StudentParentGuardianResponse studentParentGuardianResponse = new StudentParentGuardianResponse();
        try {
            StudentPersonalInfo studentPersonalInfo = studentPersonalInfoRepository.findById(studentParentGuardianRequest.getStudentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentParentGuardianRequest.getStudentId()));
            StudentParentGuardian studentParentGuardian = new StudentParentGuardian();
            BeanUtils.copyProperties(studentParentGuardianRequest, studentParentGuardian);
            studentParentGuardian.setStudentPersonalInfo(studentPersonalInfo);
            StudentParentGuardian saved = studentParentGuardianRepository.save(studentParentGuardian);
            BeanUtils.copyProperties(saved, studentParentGuardianResponse);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Father/Mother/Guardian details already exist for given student.");
        }
        return studentParentGuardianResponse;
    }

    @Override
    public StudentParentGuardianResponse updateParentGuardian(Long id, StudentParentGuardianRequest studentParentGuardianRequest) {
        System.out.println(studentParentGuardianRequest);
        StudentParentGuardian existingStudentParentGuardian = studentParentGuardianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parent/Guardian not found with ID: " + id));
        System.out.println("existingStudentParentGuardian: " + existingStudentParentGuardian);
        BeanUtils.copyProperties(studentParentGuardianRequest, existingStudentParentGuardian);
        StudentParentGuardian studentParentGuardian = studentParentGuardianRepository.save(existingStudentParentGuardian);
        StudentParentGuardianResponse studentParentGuardianResponse = new StudentParentGuardianResponse();
        BeanUtils.copyProperties(studentParentGuardian, studentParentGuardianResponse);
        return studentParentGuardianResponse;
    }

    @Override
    public StudentParentGuardianResponse getParentGuardianById(Long id) {
        StudentParentGuardian studentParentGuardian = studentParentGuardianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parent/Guardian not found with ID: " + id));
        StudentParentGuardianResponse studentParentGuardianResponse = new StudentParentGuardianResponse();
        BeanUtils.copyProperties(studentParentGuardian, studentParentGuardianResponse);
        return studentParentGuardianResponse;    }

    @Override
    public List<StudentParentGuardian> getAllParentGuardians() {
        return studentParentGuardianRepository.findAll();
    }

    @Override
    public List<StudentParentGuardian> getParentGuardiansByStudentId(Long studentId) {
        return studentParentGuardianRepository.findByStudentPersonalInfo_StudentId(studentId);
    }


    @Override
    public void deleteParentGuardian(Long id) {
        if(!studentParentGuardianRepository.existsById(id)){
            throw new ResourceNotFoundException("Parent/Guardian not found with ID: " + id);
        }
        studentParentGuardianRepository.deleteById(id);
    }
}
