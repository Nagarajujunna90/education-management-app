package com.nr.student.service.impl;

import com.nr.student.model.StudentMedicalInfo;
import com.nr.student.repository.StudentMedicalHistoryRepository;
import com.nr.student.service.StudentMedicalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMedicalInfoServiceImpl implements StudentMedicalInfoService {

    @Autowired
    private StudentMedicalHistoryRepository studentMedicalHistoryRepository;

    @Override
    public StudentMedicalInfo saveStudentMedicalInfo(StudentMedicalInfo studentMedicalInfo) {
        return studentMedicalHistoryRepository.save(studentMedicalInfo);
    }

    @Override
    public List<StudentMedicalInfo> getAllStudentMedicalInfo() {
        return studentMedicalHistoryRepository.findAll();
    }

    @Override
    public StudentMedicalInfo getStudentMedicalInfoById(Long id) {
        return studentMedicalHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentMedicalInfo(Long id) {
        studentMedicalHistoryRepository.deleteById(id);
    }
}
