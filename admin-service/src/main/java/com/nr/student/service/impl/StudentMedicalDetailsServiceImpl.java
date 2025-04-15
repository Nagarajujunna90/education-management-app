package com.nr.student.service.impl;

import com.nr.student.model.StudentMedicalDetails;
import com.nr.student.repository.StudentMedicalDetailsRepository;
import com.nr.student.service.StudentMedicalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMedicalDetailsServiceImpl implements StudentMedicalInfoService {

    @Autowired
    private StudentMedicalDetailsRepository studentMedicalDetailsRepository;

    @Override
    public StudentMedicalDetails saveStudentMedicalInfo(StudentMedicalDetails studentMedicalDetails) {
        return studentMedicalDetailsRepository.save(studentMedicalDetails);
    }

    @Override
    public List<StudentMedicalDetails> getAllStudentMedicalInfo() {
        return studentMedicalDetailsRepository.findAll();
    }

    @Override
    public StudentMedicalDetails getStudentMedicalInfoById(Long id) {
        return studentMedicalDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentMedicalInfo(Long id) {
        studentMedicalDetailsRepository.deleteById(id);
    }
}
