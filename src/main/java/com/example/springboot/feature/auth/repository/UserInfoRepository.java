package com.example.springboot.feature.auth.repository;

import com.example.springboot.feature.auth.domain.UserInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    @EntityGraph(attributePaths = {"sellerCompanyInfo"})
    @Query("select u from UserInfo u where u.userId = ?1")
    Optional<UserInfo> findByUserId(String userId);
}