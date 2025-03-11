//package com.nr.student.service;
//
//import com.nr.student.exception.ResourceNotFoundException;
//import com.nr.student.model.Student;
//import com.nr.student.model.TestData;
//import com.nr.student.repo.StudentRepo;
//import jakarta.inject.Inject;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class StudentServiceTest {
//
//    @InjectMocks
//    StudentServiceImpl studentService;
//    @Mock
//    StudentRepo studentRepo;
//
//    @Test
//    public void deleteStudentById_Exception() {
//        when(studentRepo.findById(anyInt())).thenReturn(Optional.empty());
//        Assertions.assertThrows(ResourceNotFoundException.class, () -> studentService.deleteStudentById(2));
//        verify(studentRepo, never()).deleteById(2);
//    }
//
//    @Test
//    public void testDeleteStudentById() {
//        when(studentRepo.findById(anyInt())).thenReturn(Optional.of(TestData.getStudent()));
//        studentService.deleteStudentById(1);
//        verify(studentRepo, times(1)).deleteById(1);
//    }
//
//    @Test
//    public void testGetStudentById() {
//        when(studentRepo.findById(anyInt())).thenReturn(Optional.of(TestData.getStudent()));
//        Student studentById = studentService.getStudentById(1);
//        Assertions.assertEquals(1, studentById.getId());
//    }
//
//    @Test
//    public void testGetStudentBy_ResourceNotFoundException() {
//        when(studentRepo.findById(anyInt())).thenReturn(Optional.empty());
//        Assertions.assertThrows(ResourceNotFoundException.class, () -> studentService.getStudentById(2));
//        verify(studentRepo, times(1)).findById(2);
//    }
//}
