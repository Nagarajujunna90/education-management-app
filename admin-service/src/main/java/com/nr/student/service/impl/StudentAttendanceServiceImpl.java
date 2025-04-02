package com.nr.student.service.impl;

import com.nr.student.model.StudentAttendance;
import com.nr.student.repository.StudentAttendanceRepository;
import com.nr.student.service.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    @Autowired
    private StudentAttendanceRepository studentAttendanceRepository;

    @Override
    public StudentAttendance saveStudentAttendance(StudentAttendance studentAttendance) {
        return studentAttendanceRepository.save(studentAttendance);
    }

    @Override
    public List<StudentAttendance> getAllStudentAttendance() {
        return studentAttendanceRepository.findAll();
    }

    @Override
    public StudentAttendance getStudentAttendanceById(Long id) {
        return studentAttendanceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentAttendance(Long id) {
        studentAttendanceRepository.deleteById(id);
    }
}
