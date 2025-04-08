package com.nr.student.repository;

import com.nr.student.dto.StudentFilterRequest;
import com.nr.student.model.StudentPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentPersonalInfoRepository extends JpaRepository<StudentPersonalInfo,Long> {
    @Query("SELECT p FROM StudentPersonalInfo p WHERE " +
            "(:userName IS NULL OR p.userName LIKE %:userName%) AND " +
            "(:gender IS NULL OR p.gender = :gender) AND " +
            "(:age IS NULL OR p.age = :age)")
    List<StudentPersonalInfo> findByFilters(
            @Param("userName") String userName,
            @Param("gender") String gender,
            @Param("age") Integer age);

}
