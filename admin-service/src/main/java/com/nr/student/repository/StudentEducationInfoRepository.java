package com.nr.student.repository;

import com.nr.student.model.StudentEducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentEducationInfoRepository extends JpaRepository<StudentEducationInfo, Long> {
    List<StudentEducationInfo> findByStudentPersonalInfo_StudentId(Long studentId);
}
