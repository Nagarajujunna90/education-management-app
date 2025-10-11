package com.nr.student.service;

import com.nr.student.dto.StudentDocumentsRequest;
import com.nr.student.dto.StudentDocumentsResponse;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.StudentDocuments;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentDocumentRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class StudentDocumentServiceImpl implements StudentDocumentService {

    private final StudentDocumentRepository studentDocumentRepository;
    private final StudentPersonalInfoRepository personalInfoRepository;

    // Better to inject from properties
    @Value("${upload.dir}")
    private String uploadDir;

    public StudentDocumentServiceImpl(StudentDocumentRepository studentDocumentRepository,
                                      StudentPersonalInfoRepository personalInfoRepository) {
        this.studentDocumentRepository = studentDocumentRepository;
        this.personalInfoRepository = personalInfoRepository;
    }

    @Override
    public StudentDocumentsResponse saveDocument(MultipartFile file, Long studentId) throws IOException {
        StudentPersonalInfo studentPersonalInfo = personalInfoRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student details not found"));

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Save file
        String originalFileName = file.getOriginalFilename();
        String fileName = UUID.randomUUID() + "_" + originalFileName;
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Save metadata
        StudentDocuments studentDocuments = new StudentDocuments();
        studentDocuments.setStudentPersonalInfo(studentPersonalInfo);
        studentDocuments.setDocumentType(file.getContentType());
        studentDocuments.setDocumentName(originalFileName);
        studentDocuments.setDocumentUrl(filePath.toString());
        studentDocuments.setUploadedAt(LocalDateTime.now());

        StudentDocuments saved = studentDocumentRepository.save(studentDocuments);

        StudentDocumentsResponse response = new StudentDocumentsResponse();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    @Override
    public StudentDocumentsResponse getDocumentById(Long id) {
        StudentDocuments document = studentDocumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found"));
        StudentDocumentsResponse response = new StudentDocumentsResponse();
        BeanUtils.copyProperties(document, response);
        return response;
    }

    @Override
    public void deleteDocumentById(Long id) {
        if (!studentDocumentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Document not found for delete");
        }
        studentDocumentRepository.deleteById(id);
    }

    @Override
    public StudentDocumentsResponse updateDocument(Long id, MultipartFile file, StudentDocumentsRequest request) throws IOException {
        StudentDocuments existing = studentDocumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found"));

        // Replace old file with new file
        if (file != null && !file.isEmpty()) {
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String originalFileName = file.getOriginalFilename();
            String fileName = UUID.randomUUID() + "_" + originalFileName;
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            existing.setDocumentName(originalFileName);
            existing.setDocumentUrl(filePath.toString());
            existing.setDocumentType(file.getContentType());
            existing.setUploadedAt(LocalDateTime.now());
        }

        // Optional fields from request
        if (request.getDocumentType() != null) {
            existing.setDocumentType(request.getDocumentType());
        }

        StudentDocuments saved = studentDocumentRepository.save(existing);
        StudentDocumentsResponse response = new StudentDocumentsResponse();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    @Override
    public List<StudentDocuments> getDocumentByStudentId(Long studentId) {
        return studentDocumentRepository.findByStudentPersonalInfo_StudentId(studentId);
    }

    @Override
    public List<StudentDocuments> getALlDocuments() {
        return studentDocumentRepository.findAll();
    }

    public Resource downloadDocument(Long documentId) throws MalformedURLException {
        StudentDocuments doc = studentDocumentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found"));

        Path filePath = Paths.get(doc.getDocumentUrl());
        if (!Files.exists(filePath)) {
            throw new ResourceNotFoundException("File not found on disk");
        }

        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new ResourceNotFoundException("Could not read the file");
        }
    }

}
