package com.nr.student.service.impl;

import com.nr.student.dto.TeacherAddressRequest;
import com.nr.student.dto.TeacherAddressResponse;
import com.nr.student.model.TeacherAddress;
import com.nr.student.model.TeacherPersonalInfo;
import com.nr.student.repository.TeacherAddressRepository;
import com.nr.student.repository.TeacherPersonalInfoRepository;
import com.nr.student.service.TeacherAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TeacherAddressServiceImpl implements TeacherAddressService {

    @Autowired
    private TeacherAddressRepository teacherAddressRepository;

    @Autowired
    private TeacherPersonalInfoRepository teacherPersonalInfoRepository;

    @Override
    public TeacherAddressResponse saveAddress(TeacherAddressRequest TeacherAddressRequest) {
        try {
            TeacherPersonalInfo teacherPersonalInfo = teacherPersonalInfoRepository.findById(TeacherAddressRequest.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + TeacherAddressRequest.getTeacherId()));
            TeacherAddress teacherAddress = new TeacherAddress();
            BeanUtils.copyProperties(TeacherAddressRequest, teacherAddress);
            teacherAddress.setTeacherPersonalInfo(teacherPersonalInfo);
            TeacherAddress savedTeacherAddress = teacherAddressRepository.save(teacherAddress);
            TeacherAddressResponse teacherAddressResponse = new TeacherAddressResponse();
            BeanUtils.copyProperties(savedTeacherAddress, teacherAddressResponse);
            return teacherAddressResponse;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data already exists for this teacher, address.");
        }

    }

    @Override
    public TeacherAddressResponse updateAddress(TeacherAddressRequest teacherAddressRequest, Integer id) {
        TeacherAddress teacherAddress = teacherAddressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher Address not found with ID: " + id));
        BeanUtils.copyProperties(teacherAddressRequest, teacherAddress);
        TeacherAddress updatedTeacherResponse = teacherAddressRepository.save(teacherAddress);
        TeacherAddressResponse teacherAddressResponse = new TeacherAddressResponse();
        BeanUtils.copyProperties(updatedTeacherResponse, teacherAddressResponse);
        return teacherAddressResponse;
    }

    @Override
    public List<TeacherAddress> getAllAddresss() {
        return teacherAddressRepository.findAll();
    }

    @Override
    public TeacherAddressResponse getAddressById(Integer id) {
        TeacherAddress teacherAddress = teacherAddressRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher Address not found with ID: " + id));
        TeacherAddressResponse teacherAddressResponse = new TeacherAddressResponse();
        BeanUtils.copyProperties(teacherAddress, teacherAddressResponse);
        return teacherAddressResponse;
    }


    @Override
    public void deleteAddress(Integer id) {
        teacherAddressRepository.deleteById(id);
    }
}
