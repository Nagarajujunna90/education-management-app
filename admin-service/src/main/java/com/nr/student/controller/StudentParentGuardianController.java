package com.nr.student.controller;

import com.nr.student.dto.StudentParentGuardianRequest;
import com.nr.student.dto.StudentParentGuardianResponse;
import com.nr.student.model.StudentParentGuardian;
import com.nr.student.service.StudentParentGuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/student/parent-guardians")
public class StudentParentGuardianController {

    @Autowired
    private StudentParentGuardianService studentParentGuardianService;

    // Create Parent/Guardian
    @PostMapping
    public ResponseEntity<StudentParentGuardianResponse> createParentGuardian(@RequestBody StudentParentGuardianRequest studentParentGuardianRequest) {
        return new ResponseEntity<>(studentParentGuardianService.createParentGuardian(studentParentGuardianRequest), HttpStatus.CREATED);
    }

    // Update Parent/Guardian
    @PutMapping("/{id}")
    public ResponseEntity<StudentParentGuardianResponse> updateParentGuardian(@PathVariable Long id, @RequestBody StudentParentGuardianRequest studentParentGuardianRequest) {
        studentParentGuardianService.updateParentGuardian(id, studentParentGuardianRequest);
        return ResponseEntity.ok(studentParentGuardianService.updateParentGuardian(id, studentParentGuardianRequest));
    }

    // Get Parent/Guardian by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentParentGuardianResponse> getParentGuardianById(@PathVariable Long id) {
        return ResponseEntity.ok(studentParentGuardianService.getParentGuardianById(id));
    }

    // Get All Parent/Guardians
    @GetMapping
    public ResponseEntity<List<StudentParentGuardian>> getAllParentGuardians() {
        return ResponseEntity.ok(studentParentGuardianService.getAllParentGuardians());
    }

    // Get Parents/Guardians by Student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentParentGuardian>> getParentGuardiansByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentParentGuardianService.getParentGuardiansByStudentId(studentId));
    }

    // Delete Parent/Guardian
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParentGuardian(@PathVariable Long id) {
        studentParentGuardianService.deleteParentGuardian(id);
        return ResponseEntity.noContent().build(); // Cleaner way to return 204 No Content
    }
}
