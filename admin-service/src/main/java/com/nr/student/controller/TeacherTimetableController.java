package com.nr.student.controller;

import com.nr.student.dto.TeacherTimetableRequest;
import com.nr.student.dto.TeacherTimetableResponse;
import com.nr.student.service.TeacherTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/teacher/timetable")
public class TeacherTimetableController {

    @Autowired
    private TeacherTimetableService service;

    @PostMapping
    public ResponseEntity<TeacherTimetableResponse> create(@RequestBody TeacherTimetableRequest request) {
        return ResponseEntity.ok(service.createTimetable(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherTimetableResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTimetableById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeacherTimetableResponse>> getAll() {
        return ResponseEntity.ok(service.getAllTimetables());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteTimetable(id);
        return ResponseEntity.noContent().build();
    }
}
