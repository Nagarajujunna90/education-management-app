package com.nr.student.service;

import com.nr.student.dto.StudentDto;
import com.nr.student.exception.ResourceNotFoundException;
import com.nr.student.model.Address;
import com.nr.student.model.Student;
import com.nr.student.repo.AddressRepo;
import com.nr.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public Student addStudent(StudentDto studentDto) {
        Student student = new Student(studentDto);
        Student savedStudent = studentRepo.save(student);
        List<Address> addressList = studentDto.getAddressList();
        kafkaTemplate.send("student-created",savedStudent);
        addressList.get(0).setStudent(savedStudent);
        addressRepo.save(addressList.get(0));
        return savedStudent;
    }

    @Override
    public Student updateStudent(StudentDto studentDto, Integer studentId) {
        Student existingStudent = studentRepo.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student details not found"));
        if (Optional.ofNullable(existingStudent).isPresent()) existingStudent = new Student(studentDto);
        studentRepo.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student Id: " + studentId + " does not exist."));
        studentRepo.deleteById(studentId);
    }


    @Override
    public Student getStudentById(Integer studentId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student Id: " + studentId + " does not exist."));
        redisTemplate.opsForValue().set("student", student);
        Object student1 = redisTemplate.opsForValue().get("student");
        System.out.println(student1);
        return student;

    }
}
