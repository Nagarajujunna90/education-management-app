package com.nr.student.controller;

import com.nr.student.dto.TeacherExperienceRequest;
import com.nr.student.dto.TeacherExperienceResponse;
import com.nr.student.model.TeacherExperience;
import com.nr.student.service.TeacherExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/teacher/experiences")
public class TeacherExperienceController {

    private final TeacherExperienceService teacherExperienceService;

    public TeacherExperienceController(TeacherExperienceService teacherExperienceService) {
        this.teacherExperienceService = teacherExperienceService;
    }

    @PostMapping("/add")
    public ResponseEntity<TeacherExperienceResponse> addTeacherExperience(@RequestBody TeacherExperienceRequest teacherExperienceRequest) {
        return ResponseEntity.ok(teacherExperienceService.saveExperience(teacherExperienceRequest));
    }

    @PutMapping("/update/{teacherExperienceId}")
    public ResponseEntity<TeacherExperienceResponse> updateTeacherExperience(@RequestBody TeacherExperienceRequest teacherExperienceRequest, @PathVariable("teacherExperienceId") Long teacherExperienceId) {
        return ResponseEntity.ok(teacherExperienceService.updateExperience(teacherExperienceId, teacherExperienceRequest));
    }

    @GetMapping("/get/{teacherId}")
    public ResponseEntity<TeacherExperienceResponse> getTeacherExperienceByTeacherId(@PathVariable("teacherId") Long teacherId) {
        return ResponseEntity.ok(teacherExperienceService.getExperienceById(teacherId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TeacherExperience>> getAllTeacherExperience() {
        return ResponseEntity.ok(teacherExperienceService.getAllExperiences());
    }


    @DeleteMapping("/delete/{teacherExperienceId}")
    public ResponseEntity<?> deleteTeacherExperience(@PathVariable("teacherExperienceId") Long teacherExperienceId) {
        teacherExperienceService.deleteExperience(teacherExperienceId);
        return ResponseEntity.ok("Deleted teacher experience with id: " + teacherExperienceId);
    }
}
