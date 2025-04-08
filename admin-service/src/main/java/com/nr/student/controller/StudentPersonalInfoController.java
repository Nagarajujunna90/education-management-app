package com.nr.student.controller;

import com.nr.student.dto.StudentPersonalInfoRequest;
import com.nr.student.dto.StudentPersonalInfoResponse;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.service.StudentPersonalInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ems/v1/personal/student")
@Tag(name = "Student API", description = "APIs for managing students")
public class StudentPersonalInfoController {

    private StudentPersonalInfoService studentPersonalInfoService;

    public StudentPersonalInfoController(StudentPersonalInfoService studentPersonalInfoService) {
        this.studentPersonalInfoService = studentPersonalInfoService;
    }

    @PostMapping
    public ResponseEntity<StudentPersonalInfoResponse> addStudent(@RequestBody StudentPersonalInfoRequest studentPersonalInfo) {
        return new ResponseEntity<>(studentPersonalInfoService.addStudent(studentPersonalInfo), HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentPersonalInfoResponse> updateStudent(@RequestBody StudentPersonalInfoRequest studentPersonalInfoRequest, @PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(studentPersonalInfoService.updateStudent(studentPersonalInfoRequest, studentId), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") Long studentId) {
        studentPersonalInfoService.deleteStudentById(studentId);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentPersonalInfo> getStudentById(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(studentPersonalInfoService.getStudentById(studentId), HttpStatus.OK);

    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentPersonalInfo>> getALlStudents() {
        return new ResponseEntity<List<StudentPersonalInfo>>(studentPersonalInfoService.getAllStudents(), HttpStatus.OK);
    }


}
