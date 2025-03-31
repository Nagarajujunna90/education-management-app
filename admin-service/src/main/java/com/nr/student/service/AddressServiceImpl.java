package com.nr.student.service;

import com.nr.student.dto.AddressRequest;
import com.nr.student.exception.AddressAlreadyExistException;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.StudentAddress;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repo.AddressRepository;
import com.nr.student.repo.StudentPersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StudentPersonalInfoRepository studentRepository;

    @Override
    public Long addAddress(AddressRequest request) {
        StudentPersonalInfo studentPersonalInfo = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        // Check if an address of the given type already exists for the student
        boolean addressExists = addressRepository.existsByStudentPersonalInfoAndAddressType(studentPersonalInfo, request.getAddressType());
        if (addressExists) {
            throw new AddressAlreadyExistException("Student already has a " + request.getAddressType() + " address.");
        }

        StudentAddress studentAddress = new StudentAddress();
        studentAddress.setStudentPersonalInfo(studentPersonalInfo);  // Associate with student
        studentAddress.setAddressType(request.getAddressType());
        studentAddress.setFlatNumber(request.getFlatNumber());
        studentAddress.setStreet(request.getStreet());
        studentAddress.setArea(request.getArea());
        studentAddress.setDistrict(request.getDistrict());
        studentAddress.setState(request.getState());
        studentAddress.setCountry(request.getCountry());

        // Save to DB
        StudentAddress studentAddress1 = addressRepository.save(studentAddress);
        return studentAddress1.getAddressId();

    }

    @Override
    public StudentAddress getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + id));
    }

    @Override
    public List<StudentAddress> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public StudentAddress updateAddress(Long id, StudentAddress studentAddress) {
        StudentAddress existingStudentAddress = getAddressById(id);

        existingStudentAddress.setFlatNumber(studentAddress.getFlatNumber());
        existingStudentAddress.setStreet(studentAddress.getStreet());
        existingStudentAddress.setArea(studentAddress.getArea());
        existingStudentAddress.setDistrict(studentAddress.getDistrict());
        existingStudentAddress.setState(studentAddress.getState());
        existingStudentAddress.setCountry(studentAddress.getCountry());

        return addressRepository.save(existingStudentAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}

