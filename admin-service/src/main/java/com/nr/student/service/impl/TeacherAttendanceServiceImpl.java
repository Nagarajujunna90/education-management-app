package com.nr.student.service.impl;

import com.nr.student.dto.TeacherAttendanceRequest;
import com.nr.student.dto.TeacherAttendanceResponse;
import com.nr.student.model.TeacherAttendance;
import com.nr.student.model.TeacherPersonalInfo;
import com.nr.student.repository.TeacherAttendanceRepository;
import com.nr.student.repository.TeacherPersonalInfoRepository;
import com.nr.student.service.TeacherAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherAttendanceServiceImpl implements TeacherAttendanceService {

    @Autowired
    private TeacherAttendanceRepository teacherAttendanceRepository;

    @Autowired
    private TeacherPersonalInfoRepository teacherPersonalInfoRepository;

    @Override
    public TeacherAttendanceResponse createAttendance(TeacherAttendanceRequest request) {
        TeacherPersonalInfo teacher = teacherPersonalInfoRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        TeacherAttendance attendance = new TeacherAttendance();
        attendance.setDate(request.getDate());
        attendance.setIsPresent(request.getIsPresent());
        attendance.setTeacherPersonalInfo(teacher);

        TeacherAttendance savedAttendance = teacherAttendanceRepository.save(attendance);
        return mapToResponse(savedAttendance);
    }

    @Override
    public TeacherAttendanceResponse getAttendanceById(Long id) {
        TeacherAttendance attendance = teacherAttendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance record not found"));
        return mapToResponse(attendance);
    }

    @Override
    public List<TeacherAttendanceResponse> getAllAttendances() {
        List<TeacherAttendance> attendances = teacherAttendanceRepository.findAll();
        return attendances.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteAttendance(Long id) {
        teacherAttendanceRepository.deleteById(id);
    }

    private TeacherAttendanceResponse mapToResponse(TeacherAttendance attendance) {
        TeacherAttendanceResponse response = new TeacherAttendanceResponse();
        response.setId(attendance.getId());
        response.setDate(attendance.getDate());
        response.setIsPresent(attendance.getIsPresent());
        //response.setTeacherId(attendance.getTeacherPersonalInfo().getTeacherId());
        return response;
    }
}
