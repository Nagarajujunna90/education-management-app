package com.nr.student.service.impl;

import com.nr.student.dto.StudentPersonalInfoRequest;
import com.nr.student.dto.StudentPersonalInfoResponse;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentAddressRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import com.nr.student.service.AuthServiceClient;
import com.nr.student.service.StudentPersonalInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentPersonalInfoServiceImpl implements StudentPersonalInfoService {

    @Autowired
    StudentPersonalInfoRepository studentPersonalInfoRepository;

    @Autowired
    StudentAddressRepository studentAddressRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    AuthServiceClient authServiceClient;


    @Override
    public StudentPersonalInfoResponse addStudent(StudentPersonalInfoRequest studentPersonalInfoDto) {
        StudentPersonalInfoResponse studentPersonalInfoResponse;
        try {
            StudentPersonalInfo studentPersonalInfo = new StudentPersonalInfo();
            BeanUtils.copyProperties(studentPersonalInfoDto, studentPersonalInfo);
           // Long userId = authServiceClient.getUserIdByUserName(studentPersonalInfoDto.getUserName());
            Random random = new Random();
            Long randomNumber = 10000 + random.nextLong(90000);
            studentPersonalInfo.setRegistrationId(randomNumber);
            StudentPersonalInfo savedStudentPersonalInfo = studentPersonalInfoRepository.save(studentPersonalInfo);
            // kafkaTemplate.send("student-created", savedStudent);
            studentPersonalInfoResponse = new StudentPersonalInfoResponse();
            BeanUtils.copyProperties(savedStudentPersonalInfo, studentPersonalInfoResponse);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DataIntegrityViolationException("Student username/details already registered");
        }
        return studentPersonalInfoResponse;

    }

    @Override
    public StudentPersonalInfoResponse updateStudent(StudentPersonalInfoRequest studentPersonalInfoRequest, Long studentId) {
        StudentPersonalInfo existingStudentPersonalInfo = studentPersonalInfoRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student details not found"));
        StudentPersonalInfoResponse studentPersonalInfoResponse;
        BeanUtils.copyProperties(studentPersonalInfoRequest, existingStudentPersonalInfo);
        StudentPersonalInfo savedStudentPersonalInfo = studentPersonalInfoRepository.save(existingStudentPersonalInfo);
        studentPersonalInfoResponse = new StudentPersonalInfoResponse();
        BeanUtils.copyProperties(savedStudentPersonalInfo, studentPersonalInfoResponse);
        return studentPersonalInfoResponse;
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentPersonalInfoRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student Id: " + studentId + " does not exist."));
        studentPersonalInfoRepository.deleteById(studentId);
    }


    @Override
    public StudentPersonalInfo getStudentById(Long studentId) {
        return studentPersonalInfoRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student Id: " + studentId + " does not exist."));
        // redisTemplate.opsForValue().set("student", student);
        //Object student1 = redisTemplate.opsForValue().get("student");
        //System.out.println(student1);
//        StudentPersonalInfoResponse studentPersonalInfoResponse = new StudentPersonalInfoResponse();
//        BeanUtils.copyProperties(studentPersonalInfo, studentPersonalInfoResponse);
//        return studentPersonalInfoResponse;

    }

    @Override
    public List<StudentPersonalInfo> getAllStudents() {
        return studentPersonalInfoRepository.findAll();
    }
}
