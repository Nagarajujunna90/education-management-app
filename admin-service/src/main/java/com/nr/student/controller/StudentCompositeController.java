package com.nr.student.controller;

import com.nr.student.dto.StudentCompositeRequest;
import com.nr.student.service.StudentCompositeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ems/v1/students")
public class StudentCompositeController {

    private final StudentCompositeService studentCompositeService;

    public StudentCompositeController(StudentCompositeService studentCompositeService) {
        this.studentCompositeService = studentCompositeService;
    }

    @PostMapping(value = "/composite", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> saveStudentComposite(@RequestBody StudentCompositeRequest request) {
        studentCompositeService.saveStudentComposite(request);
        return new ResponseEntity<>("Student data saved successfully", HttpStatus.CREATED);
    }
}