package com.nr.student.repository;

import com.nr.student.model.StudentMedicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMedicalHistoryRepository extends JpaRepository<StudentMedicalInfo, Long> {
}
