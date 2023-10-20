package com.example.springboot.otp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OtpRepository extends JpaRepository <Otp, Long>{
    @Query("select o from Otp o where o.securityId = ?1 and o.telephone = ?2")
    Optional<Otp> findBySecurityIdAndPhoneNumber(String sessionId, String phoneNumber);
}