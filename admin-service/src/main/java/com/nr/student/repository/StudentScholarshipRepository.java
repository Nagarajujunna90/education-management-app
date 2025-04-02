package com.nr.student.repository;

import com.nr.student.model.StudentScholarships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentScholarshipRepository extends JpaRepository<StudentScholarships, Long> {
}
