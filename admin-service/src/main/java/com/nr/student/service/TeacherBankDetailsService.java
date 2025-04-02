package com.nr.student.service;


import com.nr.student.dto.TeacherBankDetailsRequest;
import com.nr.student.dto.TeacherBankDetailsResponse;
import java.util.List;

public interface TeacherBankDetailsService {
    TeacherBankDetailsResponse createBankDetails(TeacherBankDetailsRequest request);
    TeacherBankDetailsResponse getBankDetailsById(Long id);
    List<TeacherBankDetailsResponse> getAllBankDetails();
    void deleteBankDetails(Long id);
}