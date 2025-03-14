package com.nr.student.util;

public class StudentUtil {
    public static String getStudentGrade(int marks) {
        return marks >= 50 ? "PASS" : "FAIL";
    }

}
