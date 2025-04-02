package com.nr.student.service.impl;

import com.nr.student.model.StudentDisciplinaryActions;
import com.nr.student.repository.StudentDisciplinaryActionsRepository;
import com.nr.student.service.StudentDisciplinaryActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDisciplinaryActionsServiceImpl implements StudentDisciplinaryActionsService {

    @Autowired
    private StudentDisciplinaryActionsRepository studentDisciplinaryActionsRepository;

    @Override
    public StudentDisciplinaryActions saveStudentDisciplinaryActions(StudentDisciplinaryActions studentDisciplinaryActions) {
        return studentDisciplinaryActionsRepository.save(studentDisciplinaryActions);
    }

    @Override
    public List<StudentDisciplinaryActions> getAllStudentDisciplinaryActions() {
        return studentDisciplinaryActionsRepository.findAll();
    }

    @Override
    public StudentDisciplinaryActions getStudentDisciplinaryActionsById(Long id) {
        return studentDisciplinaryActionsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentDisciplinaryActions(Long id) {
        studentDisciplinaryActionsRepository.deleteById(id);
    }
}
