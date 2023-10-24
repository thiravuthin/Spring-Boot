package com.example.springboot.security.test.repository;

import com.example.springboot.security.test.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(" select u from Users u where u.userName = :username")
    Optional<Users> findByUseName(String username);
}