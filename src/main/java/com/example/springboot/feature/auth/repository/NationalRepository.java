package com.example.springboot.feature.auth.repository;

import com.example.springboot.feature.auth.domain.National;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NationalRepository extends JpaRepository<National, String> {

    @Query("SELECT n FROM National n WHERE n.nationalCode = ?1")
    Optional<National> findByNationalCode(String nationalCode);
}