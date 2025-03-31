package com.nr.student.repo;

import com.nr.student.model.TeacherDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherGovtIdRepository extends JpaRepository<TeacherDocuments, Long> {
}

