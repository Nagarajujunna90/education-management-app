package com.nr.student.controller;
import com.nr.student.dto.TeacherLeaveRequest;
import com.nr.student.dto.TeacherLeaveResponse;
import com.nr.student.service.TeacherLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/teacher/leave")
public class TeacherLeaveController {

    @Autowired
    private TeacherLeaveService service;

    @PostMapping
    public ResponseEntity<TeacherLeaveResponse> create(@RequestBody TeacherLeaveRequest request) {
        return ResponseEntity.ok(service.createLeave(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherLeaveResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLeaveById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeacherLeaveResponse>> getAll() {
        return ResponseEntity.ok(service.getAllLeaves());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteLeave(id);
        return ResponseEntity.noContent().build();
    }
}
