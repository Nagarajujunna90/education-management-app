package com.nr.student.service;

import com.nr.student.dto.StudentDocumentsRequest;
import com.nr.student.dto.StudentDocumentsResponse;
import com.nr.student.model.StudentDocuments;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface StudentDocumentService {
    StudentDocumentsResponse saveDocument(MultipartFile file, Long studentDocumentsRequest) throws IOException;

    StudentDocumentsResponse getDocumentById(Long id);

    void deleteDocumentById(Long id);


    StudentDocumentsResponse updateDocument(Long id, MultipartFile file, StudentDocumentsRequest studentDocumentsRequest) throws IOException;

    List<StudentDocuments> getDocumentByStudentId(Long studentId);


    List<StudentDocuments> getALlDocuments();

    Resource downloadDocument(Long documentId) throws MalformedURLException;
}
