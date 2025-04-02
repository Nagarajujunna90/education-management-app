package com.nr.student.repository;

import com.nr.student.model.TeacherAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherAddressRepository extends JpaRepository<TeacherAddress, Integer> {
}
