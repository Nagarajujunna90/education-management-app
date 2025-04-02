package com.nr.student.repository;

import com.nr.student.model.StudentLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLeaveRepository extends JpaRepository<StudentLeave, Long> {
}
