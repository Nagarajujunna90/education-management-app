//package com.nr.student.service;
//
//import com.nr.student.model.TeacherPersonalDetails;
//import com.nr.student.repo.TeacherPersonalDetailsRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TeacherPersonalDetailsServiceImpl implements TeacherPersonalDetailsService {
//
//    @Autowired
//    private TeacherPersonalDetailsRepository personalDetailsRepository;
//
//    @Override
//    public TeacherPersonalDetails savePersonalDetails(TeacherPersonalDetails personalDetails) {
//        return personalDetailsRepository.save(personalDetails);
//    }
//
//    @Override
//    public List<TeacherPersonalDetails> getAllPersonalDetails() {
//        return personalDetailsRepository.findAll();
//    }
//
//    @Override
//    public Optional<TeacherPersonalDetails> getPersonalDetailsById(Integer id) {
//        return personalDetailsRepository.findById(id);
//    }
//
//    @Override
//    public TeacherPersonalDetails updatePersonalDetails(Integer id, TeacherPersonalDetails updatedDetails) {
//        return personalDetailsRepository.findById(id).map(personalDetails -> {
//            personalDetails.setFirstName(updatedDetails.getFirstName());
//            personalDetails.setLastName(updatedDetails.getLastName());
//            return personalDetailsRepository.save(personalDetails);
//        }).orElseThrow(() -> new RuntimeException("Personal details not found with ID: " + id));
//    }
//
//    @Override
//    public void deletePersonalDetails(Integer id) {
//        personalDetailsRepository.deleteById(id);
//    }
//}
