package com.nr.student.service.impl;

import com.nr.student.dto.AddressRequest;
import com.nr.student.exception.AddressAlreadyExistException;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.StudentAddress;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentAddressRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import com.nr.student.service.AddressService;
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
    public Long addAddress(AddressRequest request) {
        StudentPersonalInfo studentPersonalInfo = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        // Check if an address of the given type already exists for the student
        boolean addressExists = studentAddressRepository.existsByStudentPersonalInfoAndAddressType(studentPersonalInfo, request.getAddressType());
        if (addressExists) {
            throw new AddressAlreadyExistException("Student already has a " + request.getAddressType() + " address.");
        }

        StudentAddress studentAddress = new StudentAddress();
        studentAddress.setStudentPersonalInfo(studentPersonalInfo);  // Associate with student
        studentAddress.setAddressType(request.getAddressType());
        studentAddress.setHouseNumber(request.getHouseNumber());
        studentAddress.setArea(request.getArea());
        studentAddress.setCity(request.getCity());
        studentAddress.setState(request.getState());
        studentAddress.setCountry(request.getCountry());
        studentAddress.setZipCode(request.getZipCode());

        // Save to DB
        StudentAddress studentAddress1 = studentAddressRepository.save(studentAddress);
        return studentAddress1.getAddressId();

    }

    @Override
    public StudentAddress getAddressById(Long id) {
        return studentAddressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + id));
    }

    @Override
    public List<StudentAddress> getAllAddresses() {
        return studentAddressRepository.findAll();
    }

    @Override
    public StudentAddress updateAddress(Long id, StudentAddress studentAddress) {
        StudentAddress existingStudentAddress = getAddressById(id);
        existingStudentAddress.setHouseNumber(studentAddress.getHouseNumber());
        existingStudentAddress.setArea(studentAddress.getArea());
        existingStudentAddress.setCity(studentAddress.getCity());
        existingStudentAddress.setState(studentAddress.getState());
        existingStudentAddress.setCountry(studentAddress.getCountry());
        existingStudentAddress.setZipCode(studentAddress.getZipCode());
        return studentAddressRepository.save(existingStudentAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        studentAddressRepository.deleteById(id);
    }
}

