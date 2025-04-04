package com.nr.student.service.impl;

import com.nr.student.model.TeacherDocuments;
import com.nr.student.repository.TeacherDocumentsIdRepository;
import com.nr.student.service.TeacherDocumentsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherDocumentsServiceImpl implements TeacherDocumentsService {

    @Autowired
    private TeacherDocumentsIdRepository govtIdRepository;

    @Override
    public TeacherDocuments saveGovtId(TeacherDocuments govtId) {
        return govtIdRepository.save(govtId);
    }

    @Override
    public List<TeacherDocuments> getAllGovtIds() {
        return govtIdRepository.findAll();
    }

    @Override
    public Optional<TeacherDocuments> getGovtIdById(Long id) {
        return govtIdRepository.findById(id);
    }

    @Override
    public TeacherDocuments updateGovtId(Long id, TeacherDocuments updatedGovtId) {
        return govtIdRepository.save(updatedGovtId);
    }

    @Override
    public void deleteGovtId(Long id) {
        govtIdRepository.deleteById(id);
    }
}
