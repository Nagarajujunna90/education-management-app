package com.nr.student.service;

import com.nr.student.dto.AddressRequest;
import com.nr.student.model.StudentAddress;

import java.util.List;

public interface AddressService {
    Long addAddress(AddressRequest request);

    StudentAddress getAddressById(Long id);

    List<StudentAddress> getAllAddresses();

    StudentAddress updateAddress(Long id, StudentAddress studentAddress);

    void deleteAddress(Long id);
}

