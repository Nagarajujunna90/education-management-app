package com.nr.student.service;

import com.nr.student.model.Teacher;
import com.nr.student.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacher(Integer teacherId) {
        teacherRepo.deleteById(teacherId);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, Integer teacherId) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Integer teacherId) {
        return teacherRepo.findById(teacherId).orElseThrow();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }
}
