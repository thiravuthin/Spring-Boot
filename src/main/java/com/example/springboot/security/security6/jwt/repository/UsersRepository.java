package com.example.springboot.security.security6.jwt.repository;

import com.example.springboot.security.security6.jwt.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
 Optional<Users> findByEmail(String email);
}