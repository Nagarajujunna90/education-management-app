package com.nr.student.repository;

import com.nr.student.model.TeacherPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherPersonalInfo, Integer> {
}
