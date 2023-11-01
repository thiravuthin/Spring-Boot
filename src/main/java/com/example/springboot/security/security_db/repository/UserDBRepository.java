package com.example.springboot.security.security_db.repository;

import com.example.springboot.security.security_db.domain.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDBRepository extends JpaRepository<UserDB, Long> {
    @Query("SELECT u FROM UserDB u where u.userName = ?1")
    Optional<UserDB> findByUserName(String username);
}