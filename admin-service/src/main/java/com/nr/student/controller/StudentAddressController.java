package com.nr.student.controller;

import com.nr.student.dto.AddressRequest;
import com.nr.student.model.StudentAddress;
import com.nr.student.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ems/v1/student/addresses")
public class StudentAddressController {

    @Autowired
    private AddressService addressService;

    // Create Address
    @PostMapping
    public ResponseEntity<?> createAddress(@Valid @RequestBody AddressRequest address) {
        Long addressId = addressService.addAddress(address);
        return new ResponseEntity<>(addressId, HttpStatus.CREATED);
    }

    // Get Address by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentAddress> getAddressById(@PathVariable Long id) {
        StudentAddress studentAddress = addressService.getAddressById(id);
        return ResponseEntity.ok(studentAddress);
    }

    // Get All Addresses
    @GetMapping
    public ResponseEntity<List<StudentAddress>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    // Update Address
    @PutMapping("/{id}")
    public ResponseEntity<StudentAddress> updateAddress(@PathVariable Long id, @RequestBody StudentAddress studentAddress) {
        StudentAddress updatedStudentAddress = addressService.updateAddress(id, studentAddress);
        return ResponseEntity.ok(updatedStudentAddress);
    }

    // Delete Address
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Address deleted successfully!");
    }
}