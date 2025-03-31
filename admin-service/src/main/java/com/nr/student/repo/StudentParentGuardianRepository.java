package com.nr.student.repo;

import com.nr.student.model.StudentParentGuardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentParentGuardianRepository extends JpaRepository<StudentParentGuardian, Long> {
    List<StudentParentGuardian> findByStudentPersonalInfo_StudentId(Long studentId);
}
