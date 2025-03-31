package com.nr.student.repo;

import com.nr.student.model.StudentPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPersonalInfoRepository extends JpaRepository<StudentPersonalInfo,Long> {

}
