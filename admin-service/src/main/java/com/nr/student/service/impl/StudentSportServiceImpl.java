package com.nr.student.service.impl;

import com.nr.student.model.StudentSport;
import com.nr.student.repository.StudentSportRepository;
import com.nr.student.service.StudentSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSportServiceImpl implements StudentSportService {

    @Autowired
    private StudentSportRepository studentSportRepository;

    @Override
    public StudentSport saveStudentSport(StudentSport studentSport) {
        return studentSportRepository.save(studentSport);
    }

    @Override
    public List<StudentSport> getAllStudentSport() {
        return studentSportRepository.findAll();
    }

    @Override
    public StudentSport getStudentSportById(Long id) {
        return studentSportRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentSport(Long id) {
        studentSportRepository.deleteById(id);
    }
}
