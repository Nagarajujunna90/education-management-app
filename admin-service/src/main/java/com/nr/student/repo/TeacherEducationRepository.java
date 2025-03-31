package com.nr.student.repo;

import com.nr.student.model.TeacherEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherEducationRepository extends JpaRepository<TeacherEducation, Long> {
}

