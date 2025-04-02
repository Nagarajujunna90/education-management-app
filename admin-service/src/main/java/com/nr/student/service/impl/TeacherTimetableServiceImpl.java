package com.nr.student.service.impl;

import com.nr.student.dto.TeacherTimetableRequest;
import com.nr.student.dto.TeacherTimetableResponse;
import com.nr.student.model.TeacherTimetable;
import com.nr.student.model.TeacherPersonalInfo;
import com.nr.student.repository.TeacherTimetableRepository;
import com.nr.student.repository.TeacherPersonalInfoRepository;
import com.nr.student.service.TeacherTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherTimetableServiceImpl implements TeacherTimetableService {

    @Autowired
    private TeacherTimetableRepository repository;

    @Autowired
    private TeacherPersonalInfoRepository teacherRepository;

    @Override
    public TeacherTimetableResponse createTimetable(TeacherTimetableRequest request) {
        TeacherPersonalInfo teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        TeacherTimetable timetable = new TeacherTimetable();
        timetable.setDayOfWeek(request.getDayOfWeek());
        timetable.setPeriod(request.getPeriod());
        timetable.setSubject(request.getSubject());
        timetable.setTeacherPersonalInfo(teacher);

        TeacherTimetable savedTimetable = repository.save(timetable);
        return mapToResponse(savedTimetable);
    }

    @Override
    public TeacherTimetableResponse getTimetableById(Long id) {
        TeacherTimetable timetable = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Timetable not found"));
        return mapToResponse(timetable);
    }

    @Override
    public List<TeacherTimetableResponse> getAllTimetables() {
        List<TeacherTimetable> timetables = repository.findAll();
        return timetables.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteTimetable(Long id) {
        repository.deleteById(id);
    }

    private TeacherTimetableResponse mapToResponse(TeacherTimetable timetable) {
        TeacherTimetableResponse response = new TeacherTimetableResponse();
        response.setId(timetable.getId());
        response.setDayOfWeek(timetable.getDayOfWeek());
        response.setPeriod(timetable.getPeriod());
        response.setSubject(timetable.getSubject());
       // response.setTeacherId(timetable.getTeacherPersonalInfo().getId());
        return response;
    }
}

