package com.nr.student.repo;

import com.nr.student.model.StudentAddress;
import com.nr.student.model.StudentPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<StudentAddress, Long> {
    // Check if a student already has a given address type (present/permanent)
    boolean existsByStudentPersonalInfoAndAddressType(StudentPersonalInfo studentPersonalInfo, String addressType);

}
