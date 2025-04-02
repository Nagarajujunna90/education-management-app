package com.nr.student.service;

import com.nr.student.model.StudentSport;
import java.util.List;

public interface StudentSportService {
    StudentSport saveStudentSport(StudentSport studentSport);
    List<StudentSport> getAllStudentSport();
    StudentSport getStudentSportById(Long id);
    void deleteStudentSport(Long id);
}
