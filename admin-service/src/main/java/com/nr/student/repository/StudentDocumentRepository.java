package com.nr.student.repository;

import com.nr.student.model.StudentDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDocumentRepository extends JpaRepository<StudentDocuments, Long> {
//      Custom query methods can be defined here if needed
//     For example, to find documents by student ID:

     List<StudentDocuments> findByStudentPersonalInfo_StudentId(Long studentId);
}
