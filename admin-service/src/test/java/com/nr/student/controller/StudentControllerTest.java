//package com.nr.student.controller;
//
//import com.nr.student.dto.StudentDto;
//import com.nr.student.model.Student;
//import com.nr.student.model.TestData;
//import com.nr.student.service.StudentService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class StudentControllerTest {
//
//    @InjectMocks
//    StudentController studentController;
//
//    @Mock
//    StudentService studentService;
//
//    @Test
//    public void addEmployeeTest() {
//        Student student = TestData.getStudent();
//        StudentDto studentDto = TestData.getStudentDto();
//        when(studentService.addStudent(any())).thenReturn(student);
//        ResponseEntity<Student> studentResponseEntity = studentController.addStudent(studentDto);
//        Assertions.assertEquals(studentDto.getName(), studentResponseEntity.getBody().getName());
//    }
//
//    @Test
//    public void deleteStudentByIdTest() {
//        Integer studentId = 1;
//        studentController.deleteStudentById(studentId);
//        verify(studentService, times(1)).deleteStudentById(studentId);
//    }
//
//    @Test
//    public void getStudentByIdTest() {
//        Integer studentId = 1;
//        when(studentService.getStudentById(any())).thenReturn(TestData.getStudent());
//        ResponseEntity<Student> response = studentController.getStudentById(studentId);
//        Assertions.assertEquals(1, response.getBody().getId());
//    }
//
//    @Test
//    public void updateStudent() {
//        when(studentService.updateStudent(any(), anyInt())).thenReturn(TestData.getStudent());
//        ResponseEntity<Student> response = studentController.updateStudent(TestData.getStudentDto(), 1);
//        Assertions.assertEquals(TestData.getStudent().getName(), response.getBody().getName());
//    }
//
//}
