package com.nr.student.service.impl;

import com.nr.student.dto.TeacherBankDetailsRequest;
import com.nr.student.dto.TeacherBankDetailsResponse;
import com.nr.student.model.TeacherBankDetails;
import com.nr.student.model.TeacherPersonalInfo;
import com.nr.student.repository.TeacherBankDetailsRepository;
import com.nr.student.repository.TeacherPersonalInfoRepository;
import com.nr.student.service.TeacherBankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherBankDetailsServiceImpl implements TeacherBankDetailsService {

    @Autowired
    private TeacherBankDetailsRepository teacherBankDetailsRepository;

    @Autowired
    private TeacherPersonalInfoRepository teacherPersonalInfoRepository;

    @Override
    public TeacherBankDetailsResponse createBankDetails(TeacherBankDetailsRequest request) {
        TeacherPersonalInfo teacher = teacherPersonalInfoRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        TeacherBankDetails bankDetails = new TeacherBankDetails();
        bankDetails.setBankName(request.getBankName());
        bankDetails.setAccountNumber(request.getAccountNumber());
        bankDetails.setIfscCode(request.getIfscCode());
        bankDetails.setBranchName(request.getBranchName());
        bankDetails.setTeacherPersonalInfo(teacher);

        TeacherBankDetails savedDetails = teacherBankDetailsRepository.save(bankDetails);
        return mapToResponse(savedDetails);
    }

    @Override
    public TeacherBankDetailsResponse getBankDetailsById(Long id) {
        TeacherBankDetails details = teacherBankDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank details not found"));
        return mapToResponse(details);
    }

    @Override
    public List<TeacherBankDetailsResponse> getAllBankDetails() {
        List<TeacherBankDetails> details = teacherBankDetailsRepository.findAll();
        return details.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteBankDetails(Long id) {
        teacherBankDetailsRepository.deleteById(id);
    }

    private TeacherBankDetailsResponse mapToResponse(TeacherBankDetails details) {
        TeacherBankDetailsResponse response = new TeacherBankDetailsResponse();
        response.setId(details.getId());
        response.setBankName(details.getBankName());
        response.setAccountNumber(details.getAccountNumber());
        response.setIfscCode(details.getIfscCode());
        response.setBranchName(details.getBranchName());
     //   response.setTeacherId(details.getTeacherPersonalInfo().getId());
        return response;
    }
}
