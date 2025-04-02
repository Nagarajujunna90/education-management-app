package com.nr.student.repository;

import com.nr.student.model.StudentPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPerformanceRepository extends JpaRepository<StudentPerformance, Long> {
}
