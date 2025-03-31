package com.nr.student.controller;

import com.nr.student.dto.TeacherEducationRequest;
import com.nr.student.dto.TeacherEducationResponse;
import com.nr.student.model.TeacherEducation;
import com.nr.student.service.TeacherEducationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/teacher/educations")
@Tag(name = "TeacherEducation API", description = "APIs for managing teacher education details")
public class TeacherEducationController {

    @Autowired
    private TeacherEducationService teacherEducationService;

    @PostMapping
    public ResponseEntity<TeacherEducationResponse> addTeacherEducation(@RequestBody TeacherEducationRequest teacherEducationRequest) {
        return new ResponseEntity<>(teacherEducationService.saveEducation(teacherEducationRequest), HttpStatus.OK);
    }

    @PutMapping("/{teacherEducationId}")
    public ResponseEntity<TeacherEducationResponse> updateTeacherEducation(@RequestBody TeacherEducationRequest teacherEducationRequest, @PathVariable Long teacherEducationId) {
        return new ResponseEntity<>(teacherEducationService.updateEducation(teacherEducationId, teacherEducationRequest), HttpStatus.OK);
    }

    @GetMapping("/{teacherEducationId}")
    public ResponseEntity<TeacherEducationResponse> getTeacherEducationById(@PathVariable Long teacherEducationId) {
        return new ResponseEntity<>(teacherEducationService.getEducationById(teacherEducationId), HttpStatus.OK);
    }

    @DeleteMapping("/{teacherEducationId}")
    public ResponseEntity<?> deleteTeacherEducation(@PathVariable Long teacherEducationId) {
        teacherEducationService.deleteEducation(teacherEducationId);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeacherEducation>> getAllTeacherEducations() {
        return new ResponseEntity<>(teacherEducationService.getAllEducations(), HttpStatus.OK);
    }
}