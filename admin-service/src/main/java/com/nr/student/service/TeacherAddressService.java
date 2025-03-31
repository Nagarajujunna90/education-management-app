package com.nr.student.service;

import com.nr.student.dto.TeacherAddressRequest;
import com.nr.student.dto.TeacherAddressResponse;
import com.nr.student.model.TeacherAddress;

import java.util.List;

public interface TeacherAddressService {
    TeacherAddressResponse saveAddress(TeacherAddressRequest TeacherAddressRequest);
    List<TeacherAddress> getAllAddresss();
    TeacherAddressResponse getAddressById(Integer id);
    TeacherAddressResponse updateAddress(TeacherAddressRequest TeacherAddressRequest, Integer id);
    void deleteAddress(Integer id);
}
