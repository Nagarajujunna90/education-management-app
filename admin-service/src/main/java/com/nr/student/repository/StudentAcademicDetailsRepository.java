package com.nr.student.repository;

import com.nr.student.model.StudentPreviousAcademicDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentAcademicDetailsRepository extends JpaRepository<StudentPreviousAcademicDetails, Long> {
//    @Query("SELECT a FROM StudentAcademicDetails a WHERE a.student.studentId = :studentId")
    List<StudentPreviousAcademicDetails> findByStudentPersonalInfo_studentId(Long studentId);

}
