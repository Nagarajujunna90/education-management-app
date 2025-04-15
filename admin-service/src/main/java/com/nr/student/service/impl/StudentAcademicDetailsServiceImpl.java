package com.nr.student.service.impl;

import com.nr.student.dto.StudentAcademicDetailsRequest;
import com.nr.student.dto.StudentAcademicDetailsResponse;
import com.nr.student.dto.StudentAddressResponse;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.StudentPreviousAcademicDetails;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentAcademicDetailsRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import com.nr.student.service.StudentAcademicDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        StudentPreviousAcademicDetails studentPreviousAcademicDetails = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Academic Id not found"));
        StudentAcademicDetailsResponse studentResponse = new StudentAcademicDetailsResponse();
        BeanUtils.copyProperties(studentPreviousAcademicDetails, studentResponse);
        return studentResponse;

    }

    @Override
    public StudentAcademicDetailsResponse saveStudent(StudentAcademicDetailsRequest studentDTO) {
        StudentPersonalInfo studentInfo = studentRepository.findById(studentDTO.getStudentId()).orElseThrow(() -> new RuntimeException("Student not found"));
        StudentPreviousAcademicDetails student = new StudentPreviousAcademicDetails();
        BeanUtils.copyProperties(studentDTO, student);
        student.setStudentPersonalInfo(studentInfo);
        StudentPreviousAcademicDetails savedStudent = repository.save(student);
        StudentAcademicDetailsResponse  studentResponse = new StudentAcademicDetailsResponse();
        BeanUtils.copyProperties(savedStudent, studentResponse);
        return studentResponse;
    }

    @Override
    public StudentAcademicDetailsResponse updateStudent(Long id, StudentAcademicDetailsRequest studentAcademicDetailsRequest) {
        StudentPreviousAcademicDetails existingAcademicDetails = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
        BeanUtils.copyProperties(studentAcademicDetailsRequest, existingAcademicDetails);
        StudentPreviousAcademicDetails updatedStudent = repository.save(existingAcademicDetails);
        StudentAcademicDetailsResponse studentResponse = new StudentAcademicDetailsResponse();
        BeanUtils.copyProperties(updatedStudent, studentResponse);
        return studentResponse;
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<StudentAcademicDetailsResponse> getStudentByStudentId(Long studentId) {
        List<StudentPreviousAcademicDetails> academicDetailsList =
                repository.findByStudentPersonalInfo_studentId(studentId);

        List<StudentAcademicDetailsResponse> responseList = new ArrayList<>();

        for (StudentPreviousAcademicDetails academicDetails : academicDetailsList) {
            StudentAcademicDetailsResponse response = new StudentAcademicDetailsResponse();
            BeanUtils.copyProperties(academicDetails, response);
            responseList.add(response);
        }

        return responseList;
    }


    private StudentAcademicDetailsResponse convertToResponseDTO(StudentPreviousAcademicDetails student) {
        StudentAcademicDetailsResponse responseDTO = new StudentAcademicDetailsResponse();
        responseDTO.setId(student.getId());
        responseDTO.setGrade(student.getGrade());
        responseDTO.setSection(student.getSection());
        return responseDTO;
    }
}
