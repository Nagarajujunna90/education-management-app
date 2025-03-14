//package com.nr.student.util;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.MockedStatic;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.mockStatic;
//import static org.mockito.Mockito.times;
//
//public class StudentUtilTest {
//
//    @Test
//    void testStudentGrade() {
//        try (MockedStatic<StudentUtil> mockedStatic = mockStatic(StudentUtil.class)) {
//            mockedStatic.when(() -> StudentUtil.getStudentGrade(80)).thenReturn("Excellent");
//            Assertions.assertEquals("Excellent", StudentUtil.getStudentGrade(80));
//            mockedStatic.verify(() -> StudentUtil.getStudentGrade(80), times(1));
//        }
//    }
//}
