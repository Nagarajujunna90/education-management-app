package com.nr.student.controller;

import com.nr.student.dto.TeacherPersonalInfoRequest;
import com.nr.student.model.TeacherPersonalInfo;
import com.nr.student.service.TeacherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/personal/teacher")
@Tag(name = "Teacher API", description = "APIs for managing students")
public class TeacherPersonalInfoController {


    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherPersonalInfo> addTeacher(@RequestBody TeacherPersonalInfoRequest teacherPersonalInfoRequest) {
        return new ResponseEntity<>(teacherService.addTeacher(teacherPersonalInfoRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherPersonalInfo> updateTeacher(@RequestBody TeacherPersonalInfoRequest teacherPersonalInfoRequest, @PathVariable Long teacherId) {
        return new ResponseEntity<>(teacherService.updateTeacher(teacherPersonalInfoRequest, teacherId), HttpStatus.OK);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherPersonalInfo> getTeacherById(@PathVariable Long teacherId) {
        return new ResponseEntity<>(teacherService.getTeacherById(teacherId), HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<TeacherPersonalInfo>> getAllTeachers() {
        return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
    }
}
