package com.nr.student.service;

import com.nr.student.dto.TeacherLeaveRequest;
import com.nr.student.dto.TeacherLeaveResponse;
import java.util.List;

public interface TeacherLeaveService {
    TeacherLeaveResponse createLeave(TeacherLeaveRequest request);
    TeacherLeaveResponse getLeaveById(Long id);
    List<TeacherLeaveResponse> getAllLeaves();
    void deleteLeave(Long id);
}
