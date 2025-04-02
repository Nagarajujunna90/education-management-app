package com.nr.student.repository;

import com.nr.student.model.TeacherAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherAttendanceRepository extends JpaRepository<TeacherAttendance, Long> {
}