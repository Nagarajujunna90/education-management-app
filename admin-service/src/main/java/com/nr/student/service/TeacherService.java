package com.nr.student.service;

import com.nr.student.dto.TeacherPersonalInfoRequest;
import com.nr.student.model.TeacherPersonalInfo;

import java.util.List;

public interface TeacherService {
    TeacherPersonalInfo addTeacher(TeacherPersonalInfoRequest teacherPersonalInfoRequest);

    void deleteTeacher(Long teacherId);

    TeacherPersonalInfo updateTeacher(TeacherPersonalInfoRequest teacherPersonalInfo, Long teacherId);

    TeacherPersonalInfo getTeacherById(Long teacherId);

    List<TeacherPersonalInfo> getAllTeachers();
}
