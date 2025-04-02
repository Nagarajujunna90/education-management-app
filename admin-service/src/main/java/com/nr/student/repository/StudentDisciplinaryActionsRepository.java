package com.nr.student.repository;

import com.nr.student.model.StudentDisciplinaryActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDisciplinaryActionsRepository extends JpaRepository<StudentDisciplinaryActions,Long> {
}
