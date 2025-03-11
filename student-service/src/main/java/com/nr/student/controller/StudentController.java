package com.nr.student.controller;

import com.nr.student.dto.StudentDto;
import com.nr.student.model.Student;
import com.nr.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sms/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto) {
        System.out.println("Inside student addStudent method");
        return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.OK);
    }

    @PutMapping("/student/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody StudentDto studentDto, @PathVariable("studentId") Integer studentId) {
        return new ResponseEntity<>(studentService.updateStudent(studentDto, studentId), HttpStatus.OK);
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") Integer studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);

    }

    @GetMapping("/student/students")
    public ResponseEntity<List<Student>> getALlStudents(){
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
    }


}
