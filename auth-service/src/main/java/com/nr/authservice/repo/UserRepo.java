package com.nr.authservice.repo;

import com.nr.authservice.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<CustomUser, Integer> {

    @Query("select cs from CustomUser cs")
    Optional<CustomUser> findByUserName(String username);
}
