package com.nr.student.repository;

import com.nr.student.model.StudentMedicalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMedicalDetailsRepository extends JpaRepository<StudentMedicalDetails, Long> {
}
