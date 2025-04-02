package com.nr.student.service;

import com.nr.student.dto.TeacherAttendanceRequest;
import com.nr.student.dto.TeacherAttendanceResponse;
import java.util.List;

public interface TeacherAttendanceService {
    TeacherAttendanceResponse createAttendance(TeacherAttendanceRequest request);
    TeacherAttendanceResponse getAttendanceById(Long id);
    List<TeacherAttendanceResponse> getAllAttendances();
    void deleteAttendance(Long id);
}
