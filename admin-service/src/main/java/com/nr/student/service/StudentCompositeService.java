package com.nr.student.service;

import com.nr.student.dto.StudentCompositeRequest;
import com.nr.student.model.*;
import com.nr.student.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StudentCompositeService {

    private final StudentPersonalInfoRepository personalInfoRepository;
    private final StudentParentGuardianRepository parentGuardianRepository;
    private final StudentPreviousAcademicsRepository previousAcademicsRepository;
    private final StudentAddressRepository addressRepository;
    private final StudentGradeRepository gradeRepository;
    private final StudentDocumentRepository documentRepository;

    public StudentCompositeService(StudentPersonalInfoRepository personalInfoRepository,
                                   StudentParentGuardianRepository parentGuardianRepository,
                                   StudentPreviousAcademicsRepository previousAcademicsRepository,
                                   StudentAddressRepository addressRepository,
                                   StudentGradeRepository gradeRepository,
                                   StudentDocumentRepository documentRepository) {
        this.personalInfoRepository = personalInfoRepository;
        this.parentGuardianRepository = parentGuardianRepository;
        this.previousAcademicsRepository = previousAcademicsRepository;
        this.addressRepository = addressRepository;
        this.gradeRepository = gradeRepository;
        this.documentRepository = documentRepository;
    }

    public void saveStudentComposite(StudentCompositeRequest request) {
        // Save personal info
        StudentPersonalInfo personalInfo = new StudentPersonalInfo();
        Random random = new Random();
        Long randomNumber = 10000 + random.nextLong(90000);
        personalInfo.setRegistrationId(randomNumber);
        BeanUtils.copyProperties(request.getPersonalInfo(), personalInfo);
        personalInfo = personalInfoRepository.save(personalInfo);

        // Save parent guardians
        StudentPersonalInfo finalPersonalInfo = personalInfo;
        request.getParentGuardians().forEach(parentGuardianRequest -> {
            StudentParentGuardian parentGuardian = new StudentParentGuardian();
            BeanUtils.copyProperties(parentGuardianRequest, parentGuardian);
            parentGuardian.setStudentPersonalInfo(finalPersonalInfo);
            parentGuardianRepository.save(parentGuardian);
        });

        // Save academics
        request.getAcademics().forEach(academicRequest -> {
            StudentPreviousAcademicDetails academic = new StudentPreviousAcademicDetails();
            BeanUtils.copyProperties(academicRequest, academic);
            academic.setStudentPersonalInfo(finalPersonalInfo);
            previousAcademicsRepository.save(academic);
        });

        // Save addresses
        request.getAddresses().forEach(addressRequest -> {
            StudentAddress address = new StudentAddress();
            BeanUtils.copyProperties(addressRequest, address);
            address.setStudentPersonalInfo(finalPersonalInfo);
            addressRepository.save(address);
        });

        // Save grades
        request.getGrades().forEach(gradeRequest -> {
            StudentGrade grade = new StudentGrade();
            BeanUtils.copyProperties(gradeRequest, grade);
            grade.setStudentPersonalInfo(finalPersonalInfo);
            gradeRepository.save(grade);
        });

        // Save documents
        request.getDocuments().forEach(documentRequest -> {
            StudentDocuments document = new StudentDocuments();
            BeanUtils.copyProperties(documentRequest, document);
            document.setStudentPersonalInfo(finalPersonalInfo);
            documentRepository.save(document);
        });
    }
}