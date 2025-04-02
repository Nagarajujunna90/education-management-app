package com.nr.student.repository;

import com.nr.student.model.StudentFeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentFeeRepository extends JpaRepository<StudentFeeDetails, Long> {
}
