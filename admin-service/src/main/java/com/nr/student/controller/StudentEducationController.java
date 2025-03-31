package com.nr.student.controller;

import com.nr.student.dto.StudentEducationInfoRequest;
import com.nr.student.dto.StudentEducationInfoResponse;
import com.nr.student.model.StudentEducationInfo;
import com.nr.student.service.StudentEducationInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ems/v1/student/educations")
public class StudentEducationController {

    private final StudentEducationInfoService studentEducationInfoService;

    public StudentEducationController(StudentEducationInfoService studentEducationInfoService) {
        this.studentEducationInfoService = studentEducationInfoService;
    }

    @PostMapping
    public ResponseEntity<StudentEducationInfoResponse> addStudentEducationInfo(@RequestBody StudentEducationInfoRequest studentEducationInfoRequest) {
        return ResponseEntity.ok(studentEducationInfoService.addStudentEducationInfo(studentEducationInfoRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentEducationInfoResponse> update(@RequestBody StudentEducationInfoRequest studentEducationInfo, @PathVariable Long id) {
        return ResponseEntity.ok(studentEducationInfoService.updateStudentEducationInfo(studentEducationInfo, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEducationInfoResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentEducationInfoService.getStudentEducationById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentEducationInfo>> getByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentEducationInfoService.getStudentEducationByStudentId(studentId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducationInfoById(@PathVariable Long id) {
        studentEducationInfoService.deleteStudentEducationInfo(id);
        return ResponseEntity.noContent().build();
    }
}
