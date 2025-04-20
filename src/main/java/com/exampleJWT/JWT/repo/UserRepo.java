package com.exampleJWT.JWT.repo;


import com.exampleJWT.JWT.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
