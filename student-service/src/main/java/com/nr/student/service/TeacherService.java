package com.nr.student.service;

import com.nr.student.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addTeacher(Teacher teacher);

    void deleteTeacher(Integer teacherId);

    Teacher updateTeacher(Teacher teacher, Integer teacherId);

    Teacher getTeacherById(Integer teacherId);

    List<Teacher> getAllTeachers();
}
