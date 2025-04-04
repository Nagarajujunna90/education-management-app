package com.nr.student.repository;

import com.nr.student.model.TeacherExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TeacherExperienceRepository extends JpaRepository<TeacherExperience, Long> {
}
