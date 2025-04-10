package com.nr.student.repository;

import com.nr.student.model.TeacherPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPersonalInfoRepository extends JpaRepository<TeacherPersonalInfo, Long> {
}
