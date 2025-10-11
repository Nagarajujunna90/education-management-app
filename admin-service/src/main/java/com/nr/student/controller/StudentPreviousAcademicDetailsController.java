package com.nr.student.controller;

import com.nr.student.dto.StudentAcademicDetailsRequest;
import com.nr.student.dto.StudentAcademicDetailsResponse;
import com.nr.student.service.StudentPreviousAcademicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ems/v1/student/academic")
public class StudentPreviousAcademicDetailsController {

    @Autowired
    private StudentPreviousAcademicDetailsService studentPreviousAcademicDetailsService;


    @PostMapping
    public ResponseEntity<StudentAcademicDetailsResponse> addStudent(@RequestBody StudentAcademicDetailsRequest studentDTO) {
        StudentAcademicDetailsResponse student = studentPreviousAcademicDetailsService.saveStudent(studentDTO);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentAcademicDetailsResponse> updateStudent(@PathVariable Long id, @RequestBody StudentAcademicDetailsRequest studentDTO) {
        StudentAcademicDetailsResponse updatedStudent = studentPreviousAcademicDetailsService.updateStudent(id, studentDTO);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<StudentAcademicDetailsResponse>> getAllStudents() {
        return ResponseEntity.ok(studentPreviousAcademicDetailsService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentAcademicDetailsResponse>   getStudentById(@PathVariable Long id) {
        StudentAcademicDetailsResponse student = studentPreviousAcademicDetailsService.getStudentById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentPreviousAcademicDetailsService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentAcademicDetailsResponse>> getStudentByStudentId(@PathVariable Long studentId) {
        List<StudentAcademicDetailsResponse> students = studentPreviousAcademicDetailsService.getStudentByStudentId(studentId);
        return students != null ? ResponseEntity.ok(students) : ResponseEntity.notFound().build();
    }
}
