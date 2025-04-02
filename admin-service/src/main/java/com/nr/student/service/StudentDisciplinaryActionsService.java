package com.nr.student.service;

import com.nr.student.model.StudentDisciplinaryActions;
import java.util.List;

public interface StudentDisciplinaryActionsService {
    StudentDisciplinaryActions saveStudentDisciplinaryActions(StudentDisciplinaryActions studentDisciplinaryActions);
    List<StudentDisciplinaryActions> getAllStudentDisciplinaryActions();
    StudentDisciplinaryActions getStudentDisciplinaryActionsById(Long id);
    void deleteStudentDisciplinaryActions(Long id);
}
