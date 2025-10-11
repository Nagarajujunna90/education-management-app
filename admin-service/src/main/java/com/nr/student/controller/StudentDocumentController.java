package com.nr.student.controller;

import com.nr.student.dto.StudentDocumentsRequest;
import com.nr.student.dto.StudentDocumentsResponse;
import com.nr.student.model.StudentDocuments;
import com.nr.student.service.StudentDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ems/v1/student/document")
public class StudentDocumentController {
    @Autowired
    private StudentDocumentService studentDocumentService;

    @PostMapping("/upload")
    public ResponseEntity<StudentDocumentsResponse> uploadDocument(@RequestParam("file") MultipartFile file,
                                                                   @RequestParam("studentId") Long studentId) throws IOException {
        return ResponseEntity.ok(studentDocumentService.saveDocument(file, studentId));
    }

    @GetMapping("/download/{documentId}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long documentId) throws IOException {
        Resource resource = studentDocumentService.downloadDocument(documentId);
        StudentDocumentsResponse document = studentDocumentService.getDocumentById(documentId);
        // Return file with correct content type and content disposition
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(document.getDocumentType())) // Set correct MIME type
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getDocumentType() + "\"") // Set filename for download
                .body(resource); // Send the resource (file data)


    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<?> deleteDocument(@PathVariable Long documentId) {
        studentDocumentService.deleteDocumentById(documentId);
        return ResponseEntity.ok("File deleted successfully");
    }

    @GetMapping("/{documentId}")
    public ResponseEntity<StudentDocumentsResponse> getDocumentById(@PathVariable Long documentId) {
        return ResponseEntity.ok(studentDocumentService.getDocumentById(documentId));
    }

    //get all documents by student id
    @GetMapping("/documents/student/{studentId}")
    public ResponseEntity<?> getAllDocumentsByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentDocumentService.getDocumentByStudentId(studentId));
    }

    //get all documents by student id
    @GetMapping("/documents")
    public ResponseEntity<?> getDocumentByStudentId() {
        return ResponseEntity.ok(studentDocumentService.getALlDocuments());
    }


}
