package com.nr.student.repository;

import com.nr.student.model.TeacherLeave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherLeaveRepository extends JpaRepository<TeacherLeave, Long> {
}