package com.nr.student.service.impl;

import com.nr.student.dto.StudentGradeRequest;
import com.nr.student.dto.StudentGradeResponse;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.StudentGrade;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentGradeRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import com.nr.student.service.StudentGradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentGradeServiceImpl implements StudentGradeService {

    private StudentGradeRepository studentGradeRepository;

    private StudentPersonalInfoRepository studentPersonalInfoRepository;

    public StudentGradeServiceImpl(StudentGradeRepository studentGradeRepository, StudentPersonalInfoRepository studentPersonalInfoRepository) {
        this.studentGradeRepository = studentGradeRepository;
        this.studentPersonalInfoRepository = studentPersonalInfoRepository;
    }

    @Override
    public StudentGradeResponse addStudentEducationInfo(StudentGradeRequest studentGradeRequest) {
        StudentGradeResponse studentGradeResponse = new StudentGradeResponse();
        try {
            // Fetch student info or throw exception if not found
            StudentPersonalInfo studentPersonalInfo = studentPersonalInfoRepository
                    .findById(studentGradeRequest.getStudentId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Student not found with ID: " + studentGradeRequest.getStudentId()));
            // Create a new StudentEducationInfo object and copy properties
            StudentGrade studentGrade = new StudentGrade();
            BeanUtils.copyProperties(studentGradeRequest, studentGrade);
            studentGrade.setStudentPersonalInfo(studentPersonalInfo);

            // Save and return
            StudentGrade educationInfo = studentGradeRepository.save(studentGrade);
            BeanUtils.copyProperties(educationInfo, studentGradeResponse);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data already exists for this class, section, and academic year.");
        }
        return studentGradeResponse;
    }

    @Override
    public StudentGradeResponse updateStudentEducationInfo(StudentGradeRequest studentGradeRequest, Long id) {
        StudentGrade studentGrade = studentGradeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student Education Info not found"));
        StudentGradeResponse studentGradeResponse = new StudentGradeResponse();
        if (Optional.ofNullable(studentGrade).isPresent()) {
            BeanUtils.copyProperties(studentGradeRequest, studentGrade);
            StudentGrade saved = studentGradeRepository.save(studentGrade);
            BeanUtils.copyProperties(saved, studentGradeResponse);
        }
        return studentGradeResponse;
    }

    @Override
    public StudentGradeResponse getStudentEducationById(Long id) {
        StudentGrade studentGrade = studentGradeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student Education Info not found"));
        StudentGradeResponse studentGradeResponse = new StudentGradeResponse();
        BeanUtils.copyProperties(studentGrade, studentGradeResponse);
        return studentGradeResponse;
    }

    @Override
    public void deleteStudentEducationInfo(Long studentEducationInfoId) {
        studentGradeRepository.deleteById(studentEducationInfoId);
    }

    @Override
    public StudentGrade getStudentEducationByStudentId(Long studentId) {
        return studentGradeRepository.findByStudentPersonalInfo_StudentId(studentId);
    }


}
