package com.example.springboot.security.security_jwt.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJwtRepository extends JpaRepository<UserJwt, Long> {

    Optional<UserJwt> findByEmail(String email);
}