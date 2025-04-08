package com.nr.student.service;

import com.nr.student.dto.StudentFilterRequest;
import com.nr.student.dto.StudentResponseDto;
import com.nr.student.model.StudentAcademicDetails;
import com.nr.student.model.StudentPersonalInfo;
import com.nr.student.repository.StudentAddressRepository;
import com.nr.student.repository.StudentAcademicDetailsRepository;
import com.nr.student.repository.StudentPersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentAggregationServiceImpl implements StudentAggregationService {
    @Autowired
    private StudentPersonalInfoRepository studentPersonalInfoRepository;
    @Autowired
    private StudentAcademicDetailsRepository studentAcademicDetailsRepository;
    @Autowired
    private StudentAddressRepository studentAddressRepository;

    public List<StudentResponseDto> getFilteredStudents(StudentFilterRequest filters) {
        List<StudentPersonalInfo> matchedPersonalInfos = studentPersonalInfoRepository.findByFilters(filters.getName(), filters.getGender(), filters.getAge());

        List<StudentResponseDto> result = new ArrayList<>();

        for (StudentPersonalInfo info : matchedPersonalInfos) {
            StudentResponseDto dto = new StudentResponseDto();
            dto.setStudentId(info.getStudentId());
            dto.setName(info.getUserName());
            dto.setAge(info.getAge());
            dto.setDob(String.valueOf(info.getDateOfBirth()));
            dto.setGender(info.getGender());
            dto.setFatherName(info.getFatherName());
            dto.setMotherName(info.getMotherName());


            StudentAcademicDetails grade = studentAcademicDetailsRepository.findByStudent_Id(info.getStudentId());
            dto.setStudentClass(grade.getGrade());
            dto.setSection(grade.getSection());
            dto.setRollNumber(grade.getRollNumber());

//            List<StudentAddress> address = addressRepo.findByStudentId(info.getStudentId());
//
//            if (address != null) {
//                dto.setCity(address.getCity());
//                dto.setState(address.getState());
//                dto.setPinCode(address.getPinCode());
//            }



            result.add(dto);
        }

        return result;
    }
}

