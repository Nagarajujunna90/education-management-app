package com.nr.student.service.impl;

import com.nr.student.model.StudentLeave;
import com.nr.student.repository.StudentLeaveRepository;
import com.nr.student.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLeaveServiceImpl implements StudentLeaveService {

    @Autowired
    private StudentLeaveRepository studentLeaveRepository;

    @Override
    public StudentLeave saveStudentLeave(StudentLeave studentLeave) {
        return studentLeaveRepository.save(studentLeave);
    }

    @Override
    public List<StudentLeave> getAllStudentLeave() {
        return studentLeaveRepository.findAll();
    }

    @Override
    public StudentLeave getStudentLeaveById(Long id) {
        return studentLeaveRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentLeave(Long id) {
        studentLeaveRepository.deleteById(id);
    }
}
