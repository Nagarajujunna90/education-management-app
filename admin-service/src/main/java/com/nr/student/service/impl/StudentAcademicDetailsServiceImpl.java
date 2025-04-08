package com.nr.student.service.impl;

import com.nr.student.dto.StudentAcademicDetailsRequest;
import com.nr.student.dto.StudentAcademicDetailsResponse;
import com.nr.student.model.StudentAcademicDetails;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentAcademicDetailsRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import com.nr.student.service.StudentAcademicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentAcademicDetailsServiceImpl implements StudentAcademicDetailsService {

    @Autowired
    private StudentAcademicDetailsRepository repository;

    @Autowired
    private StudentPersonalInfoRepository studentRepository;

    @Override
    public List<StudentAcademicDetailsResponse> getAllStudents() {
        return repository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentAcademicDetailsResponse getStudentById(Long id) {
        return repository.findById(id)
                .map(this::convertToResponseDTO)
                .orElse(null);
    }

    @Override
    public StudentAcademicDetailsResponse saveStudent(StudentAcademicDetailsRequest studentDTO) {
        Optional<StudentPersonalInfo> studentInfo = studentRepository.findById(studentDTO.getStudentId());
        if (studentInfo.isEmpty()) return null; // Handle student not found

        StudentAcademicDetails student = new StudentAcademicDetails();
        student.setStudent(studentInfo.get());
        student.setGrade(studentDTO.getGrade());
        student.setSection(studentDTO.getSection());
        student.setRollNumber(studentDTO.getRollNumber());
        student.setStudentStatus(studentDTO.getStudentStatus());
        student.setYear(studentDTO.getYear());

        StudentAcademicDetails savedStudent = repository.save(student);
        return convertToResponseDTO(savedStudent);
    }

    @Override
    public StudentAcademicDetailsResponse updateStudent(Long id, StudentAcademicDetailsRequest studentDTO) {
        return repository.findById(id).map(student -> {
            student.setGrade(studentDTO.getGrade());
            student.setSection(studentDTO.getSection());
            student.setRollNumber(studentDTO.getRollNumber());
            student.setStudentStatus(studentDTO.getStudentStatus());
            student.setYear(studentDTO.getYear());

            StudentAcademicDetails updatedStudent = repository.save(student);
            return convertToResponseDTO(updatedStudent);
        }).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    private StudentAcademicDetailsResponse convertToResponseDTO(StudentAcademicDetails student) {
        StudentAcademicDetailsResponse responseDTO = new StudentAcademicDetailsResponse();
        responseDTO.setId(student.getId());
        responseDTO.setStudentId(student.getStudent().getStudentId());
        responseDTO.setGrade(student.getGrade());
        responseDTO.setSection(student.getSection());
        responseDTO.setRollNumber(student.getRollNumber());
        responseDTO.setStudentStatus(student.getStudentStatus());
        responseDTO.setYear(student.getYear());
        return responseDTO;
    }
}
