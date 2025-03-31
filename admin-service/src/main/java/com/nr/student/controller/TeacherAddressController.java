package com.nr.student.controller;

import com.nr.student.dto.TeacherAddressRequest;
import com.nr.student.dto.TeacherAddressResponse;
import com.nr.student.model.TeacherAddress;
import com.nr.student.service.TeacherAddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/v1/teacher/addresses")
@Tag(name = "TeacherAddress API", description = "APIs for managing teacher Addresss")
public class TeacherAddressController {

    @Autowired
    private TeacherAddressService teacherAddressService;

    @PostMapping
    public ResponseEntity<TeacherAddressResponse> addTeacherAddress(@RequestBody TeacherAddressRequest TeacherAddressRequest) {
        return new ResponseEntity<>(teacherAddressService.saveAddress(TeacherAddressRequest), HttpStatus.OK);
    }


    @PutMapping("/{teacherAddressId}")
    public ResponseEntity<TeacherAddressResponse> updateTeacherAddress(@RequestBody TeacherAddressRequest TeacherAddressRequest, @PathVariable Integer teacherAddressId) {
        return new ResponseEntity<>(teacherAddressService.updateAddress(TeacherAddressRequest, teacherAddressId), HttpStatus.OK);
    }

    @DeleteMapping("/{teacherAddressId}")
    public ResponseEntity<?> deleteTeacherAddress(@PathVariable Integer teacherAddressId) {
        teacherAddressService.deleteAddress(teacherAddressId);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{teacherAddressId}")
    public ResponseEntity<TeacherAddressResponse> getTeacherAddressById(@PathVariable Integer teacherAddressId) {
        return new ResponseEntity<>(teacherAddressService.getAddressById(teacherAddressId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeacherAddress>> getAllTeacherAddress() {
        return new ResponseEntity<>(teacherAddressService.getAllAddresss(), HttpStatus.OK);
    }
}