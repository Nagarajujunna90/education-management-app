package com.nr.student.controller;

import com.nr.student.model.Teacher;
import com.nr.student.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @PostMapping("/")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.OK);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer teacherId) {
        teacherService.deleteTeacher(teacherId);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher, @PathVariable Integer teacherId) {
        return new ResponseEntity<>(teacherService.updateTeacher(teacher, teacherId), HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer teacherId) {
        return new ResponseEntity<>(teacherService.getTeacherById(teacherId), HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
    }
}
