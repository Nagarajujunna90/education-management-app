package com.nr.student.controller;

import com.nr.student.dto.StudentAddressRequest;
import com.nr.student.dto.StudentAddressResponse;
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
    public ResponseEntity<StudentAddressResponse> createAddress(@Valid @RequestBody StudentAddressRequest address) {
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.CREATED);
    }

    // Get Address by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentAddressResponse> getAddressById(@PathVariable Long id) {
        addressService.getAddressById(id);
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    // Get All Addresses
    @GetMapping
    public ResponseEntity<List<StudentAddress>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    // Update Address
    @PutMapping("/{id}")
    public ResponseEntity<StudentAddressResponse> updateAddress(@PathVariable Long id, @Valid @RequestBody StudentAddressRequest address) {
        return ResponseEntity.ok( addressService.updateAddress(id, address));
    }

    // Delete Address
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Address deleted successfully!");
    }
}