package com.nr.student.service;

import com.nr.student.dto.StudentDto;
import com.nr.student.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentDto studentDto);

    Student updateStudent(StudentDto studentDto, Integer studentId);

    void deleteStudentById(Integer studentId);

    Student getStudentById(Integer studentId);

    List<Student> getAllStudents();
}
