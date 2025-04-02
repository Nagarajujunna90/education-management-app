package com.nr.student.service;

import com.nr.student.dto.TeacherTimetableRequest;
import com.nr.student.dto.TeacherTimetableResponse;
import java.util.List;

public interface TeacherTimetableService {
    TeacherTimetableResponse createTimetable(TeacherTimetableRequest request);
    TeacherTimetableResponse getTimetableById(Long id);
    List<TeacherTimetableResponse> getAllTimetables();
    void deleteTimetable(Long id);
}
