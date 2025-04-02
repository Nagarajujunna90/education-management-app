package com.nr.student.repository;

import com.nr.student.model.TeacherDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDocumentsIdRepository extends JpaRepository<TeacherDocuments, Long> {
}

