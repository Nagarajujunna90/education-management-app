package com.nr.student.repository;

import com.nr.student.model.StudentAcademicDetails;
import com.nr.student.model.StudentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAcademicDetailsRepository extends JpaRepository<StudentAcademicDetails, Long> {
    @Query("SELECT a FROM StudentAcademicDetails a WHERE a.student.studentId = :studentId")
    StudentAcademicDetails findByStudent_Id(Long studentId);

}
