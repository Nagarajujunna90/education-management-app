package com.nr.student.service;


import com.nr.student.model.TeacherDocuments;

import java.util.Optional;
import java.util.List;

public interface TeacherDocumentsService {
    TeacherDocuments saveGovtId(TeacherDocuments govtId);
    List<TeacherDocuments> getAllGovtIds();
    Optional<TeacherDocuments> getGovtIdById(Long id);
    TeacherDocuments updateGovtId(Long id, TeacherDocuments updatedGovtId);
    void deleteGovtId(Long id);
}
