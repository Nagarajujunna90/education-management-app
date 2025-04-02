package com.nr.student.repository;

import com.nr.student.model.TeacherCertification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherCertificationRepository extends JpaRepository<TeacherCertification,Long> {
}
