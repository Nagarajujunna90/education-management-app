package com.nr.student.service;

import com.nr.student.dto.StudentAddressRequest;
import com.nr.student.dto.StudentAddressResponse;
import com.nr.student.model.StudentAddress;

import java.util.List;

public interface AddressService {
    StudentAddressResponse addAddress(StudentAddressRequest request);

    StudentAddressResponse getAddressById(Long id);

    List<StudentAddress> getAllAddresses();

    StudentAddressResponse updateAddress(Long id, StudentAddressRequest studentAddress);

    void deleteAddress(Long id);
}

