package com.nr.student.repository;

import com.nr.student.model.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {
    List<StudentGrade> findByStudentPersonalInfo_StudentId(Long studentId);
}
