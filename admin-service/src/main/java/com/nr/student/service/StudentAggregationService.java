package com.nr.student.service;

import com.nr.student.dto.StudentFilterRequest;
import com.nr.student.dto.StudentResponseDto;

import java.util.List;

public interface StudentAggregationService {
     List<StudentResponseDto> getFilteredStudents(StudentFilterRequest filters);
}
