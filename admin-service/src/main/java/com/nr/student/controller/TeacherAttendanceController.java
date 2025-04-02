package com.nr.student.controller;
import com.nr.student.dto.TeacherAttendanceRequest;
import com.nr.student.dto.TeacherAttendanceResponse;
import com.nr.student.service.TeacherAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/teacher/attendance")
public class TeacherAttendanceController {

    @Autowired
    private TeacherAttendanceService teacherAttendanceService;

    @PostMapping
    public ResponseEntity<TeacherAttendanceResponse> create(@RequestBody TeacherAttendanceRequest request) {
        return ResponseEntity.ok(teacherAttendanceService.createAttendance(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherAttendanceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherAttendanceService.getAttendanceById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeacherAttendanceResponse>> getAll() {
        return ResponseEntity.ok(teacherAttendanceService.getAllAttendances());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teacherAttendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}
