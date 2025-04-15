package com.nr.student.service.impl;

import com.nr.student.dto.StudentAddressRequest;
import com.nr.student.dto.StudentAddressResponse;
import com.nr.student.exception.AddressAlreadyExistException;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.StudentAddress;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentAddressRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import com.nr.student.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private StudentAddressRepository studentAddressRepository;

    @Autowired
    private StudentPersonalInfoRepository studentRepository;

    @Override
    public StudentAddressResponse addAddress(StudentAddressRequest studentAddressRequest) {
        StudentPersonalInfo studentPersonalInfo = studentRepository.findById(studentAddressRequest.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        // Check if an address of the given type already exists for the student
        boolean addressExists = studentAddressRepository.existsByStudentPersonalInfoAndAddressType(studentPersonalInfo, studentAddressRequest.getAddressType());
        if (addressExists) {
            throw new AddressAlreadyExistException("Student already has a " + studentAddressRequest.getAddressType() + " address.");
        }
        StudentAddress studentAddress=new StudentAddress();
        BeanUtils.copyProperties(studentAddressRequest, studentAddress);
        studentAddress.setStudentPersonalInfo(studentPersonalInfo);

        StudentAddress response = studentAddressRepository.save(studentAddress);

        StudentAddressResponse studentAddressResponse = new StudentAddressResponse();
        BeanUtils.copyProperties(response,studentAddressResponse);
        return studentAddressResponse;

    }

    @Override
    public StudentAddressResponse getAddressById(Long id) {
        StudentAddress response = studentAddressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + id));
        StudentAddressResponse studentAddressResponse = new StudentAddressResponse();
        BeanUtils.copyProperties(response,studentAddressResponse);
        return studentAddressResponse;
    }

    @Override
    public List<StudentAddress> getAllAddresses() {
        return studentAddressRepository.findAll();
    }

    @Override
    public StudentAddressResponse updateAddress(Long id, StudentAddressRequest studentAddressRequest) {
        StudentAddress existingStudentAddress = studentAddressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + id));
        StudentAddress studentAddress = new StudentAddress();
        BeanUtils.copyProperties(studentAddressRequest, studentAddress);
        studentAddress.setAddressId(existingStudentAddress.getAddressId());
        studentAddress.setStudentPersonalInfo(existingStudentAddress.getStudentPersonalInfo());
        StudentAddress studentAddress1 = studentAddressRepository.save(studentAddress);
        StudentAddressResponse studentAddressResponse = new StudentAddressResponse();
        BeanUtils.copyProperties(studentAddress1,studentAddressResponse);
        return  studentAddressResponse;
    }

    @Override
    public void deleteAddress(Long id) {
        studentAddressRepository.deleteById(id);
    }
}

