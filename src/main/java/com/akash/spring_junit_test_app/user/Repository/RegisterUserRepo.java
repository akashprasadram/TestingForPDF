package com.akash.spring_junit_test_app.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akash.spring_junit_test_app.user.dto.RegisterUser;

public interface RegisterUserRepo extends JpaRepository<RegisterUser, Integer> {

    RegisterUser findByEmail(String email);

    @Query(value = "select * from login where email = ?1", nativeQuery = true)
    RegisterUser getUserByUsername(String username);

}
