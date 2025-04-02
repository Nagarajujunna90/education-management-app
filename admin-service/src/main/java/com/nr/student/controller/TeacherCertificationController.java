package com.nr.student.controller;

import com.nr.student.dto.TeacherCertificationRequest;
import com.nr.student.dto.TeacherCertificationResponse;
import com.nr.student.service.TeacherCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/teacher/certifications")
public class TeacherCertificationController {

    @Autowired
    private TeacherCertificationService service;

    @PostMapping
    public ResponseEntity<TeacherCertificationResponse> create(@RequestBody TeacherCertificationRequest request) {
        return ResponseEntity.ok(service.createCertification(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherCertificationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCertificationById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeacherCertificationResponse>> getAll() {
        return ResponseEntity.ok(service.getAllCertifications());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCertification(id);
        return ResponseEntity.noContent().build();
    }
}
