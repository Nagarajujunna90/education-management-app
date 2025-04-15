package com.nr.student.controller;

import com.nr.student.dto.StudentGradeRequest;
import com.nr.student.dto.StudentGradeResponse;
import com.nr.student.model.StudentGrade;
import com.nr.student.service.StudentGradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ems/v1/student/grade")
public class StudentGradeController {

    private final StudentGradeService studentGradeService;

    public StudentGradeController(StudentGradeService studentGradeService) {
        this.studentGradeService = studentGradeService;
    }

    @PostMapping
    public ResponseEntity<StudentGradeResponse> addStudentEducationInfo(@RequestBody StudentGradeRequest studentGradeRequest) {
        return ResponseEntity.ok(studentGradeService.addStudentEducationInfo(studentGradeRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentGradeResponse> update(@RequestBody StudentGradeRequest studentEducationInfo, @PathVariable Long id) {
        return ResponseEntity.ok(studentGradeService.updateStudentEducationInfo(studentEducationInfo, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentGradeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentGradeService.getStudentEducationById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentGrade> getByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentGradeService.getStudentEducationByStudentId(studentId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducationInfoById(@PathVariable Long id) {
        studentGradeService.deleteStudentEducationInfo(id);
        return ResponseEntity.noContent().build();
    }
}
