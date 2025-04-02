package com.nr.student.service.impl;

import com.nr.student.model.StudentPerformance;
import com.nr.student.repository.StudentPerformanceRepository;
import com.nr.student.service.StudentPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPerformanceServiceImpl implements StudentPerformanceService {

    @Autowired
    private StudentPerformanceRepository studentPerformanceRepository;

    @Override
    public StudentPerformance saveStudentPerformance(StudentPerformance studentPerformance) {
        return studentPerformanceRepository.save(studentPerformance);
    }

    @Override
    public List<StudentPerformance> getAllStudentPerformance() {
        return studentPerformanceRepository.findAll();
    }

    @Override
    public StudentPerformance getStudentPerformanceById(Long id) {
        return studentPerformanceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentPerformance(Long id) {
        studentPerformanceRepository.deleteById(id);
    }
}
