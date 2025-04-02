package com.nr.student.repository;

import com.nr.student.model.TeacherTimetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherTimetableRepository extends JpaRepository<TeacherTimetable, Long> {
}