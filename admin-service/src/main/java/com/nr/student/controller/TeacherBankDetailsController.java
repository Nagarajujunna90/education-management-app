package com.nr.student.controller;

import com.nr.student.dto.TeacherBankDetailsRequest;
import com.nr.student.dto.TeacherBankDetailsResponse;
import com.nr.student.service.TeacherBankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/teacher/bankDetails")
public class TeacherBankDetailsController {

    @Autowired
    private TeacherBankDetailsService service;

    @PostMapping
    public ResponseEntity<TeacherBankDetailsResponse> create(@RequestBody TeacherBankDetailsRequest request) {
        return ResponseEntity.ok(service.createBankDetails(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherBankDetailsResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBankDetailsById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeacherBankDetailsResponse>> getAll() {
        return ResponseEntity.ok(service.getAllBankDetails());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteBankDetails(id);
        return ResponseEntity.noContent().build();
    }
}
