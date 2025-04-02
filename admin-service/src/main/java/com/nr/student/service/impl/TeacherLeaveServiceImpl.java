package com.nr.student.service.impl;

import com.nr.student.dto.TeacherLeaveRequest;
import com.nr.student.dto.TeacherLeaveResponse;
import com.nr.student.model.TeacherLeave;
import com.nr.student.model.TeacherPersonalInfo;
import com.nr.student.repository.TeacherLeaveRepository;
import com.nr.student.repository.TeacherPersonalInfoRepository;
import com.nr.student.service.TeacherLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherLeaveServiceImpl implements TeacherLeaveService {

    @Autowired
    private TeacherLeaveRepository teacherLeaveRepository;

    @Autowired
    private TeacherPersonalInfoRepository teacherPersonalInfoRepository;

    @Override
    public TeacherLeaveResponse createLeave(TeacherLeaveRequest request) {
        TeacherPersonalInfo teacher = teacherPersonalInfoRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        TeacherLeave leave = new TeacherLeave();
        leave.setLeaveType(request.getLeaveType());
        leave.setStartDate(request.getStartDate());
        leave.setEndDate(request.getEndDate());
        leave.setReason(request.getReason());
        leave.setTeacherPersonalInfo(teacher);

        TeacherLeave savedLeave = teacherLeaveRepository.save(leave);
        return mapToResponse(savedLeave);
    }

    @Override
    public TeacherLeaveResponse getLeaveById(Long id) {
        TeacherLeave leave = teacherLeaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));
        return mapToResponse(leave);
    }

    @Override
    public List<TeacherLeaveResponse> getAllLeaves() {
        List<TeacherLeave> leaves = teacherLeaveRepository.findAll();
        return leaves.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteLeave(Long id) {
        teacherLeaveRepository.deleteById(id);
    }

    private TeacherLeaveResponse mapToResponse(TeacherLeave leave) {
        TeacherLeaveResponse response = new TeacherLeaveResponse();
        response.setId(leave.getId());
        response.setLeaveType(leave.getLeaveType());
        response.setStartDate(leave.getStartDate());
        response.setEndDate(leave.getEndDate());
        response.setReason(leave.getReason());
        //response.setTeacherId(leave.getTeacherPersonalInfo().getId());
        return response;
    }
}
