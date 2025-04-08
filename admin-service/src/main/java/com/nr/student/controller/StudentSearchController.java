package com.nr.student.controller;

import com.nr.student.dto.StudentFilterRequest;
import com.nr.student.dto.StudentResponseDto;
import com.nr.student.service.StudentAggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ems/v1/student/search")
public class StudentSearchController {

    @Autowired
    private StudentAggregationService studentAggregationService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> searchStudents(
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Integer age
    ) {
        StudentFilterRequest filters = new StudentFilterRequest();
        filters.setName(userName);
        filters.setGender(gender);
        filters.setAge(age);

        List<StudentResponseDto> result = studentAggregationService.getFilteredStudents(filters);
        return ResponseEntity.ok(result);
    }}

