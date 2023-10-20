package com.example.springboot.feature.auth.repository;

import com.example.springboot.enums.YesOrNo;
import com.example.springboot.feature.auth.domain.SellerCompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SellerCompanyInfoRepository extends JpaRepository<SellerCompanyInfo, Long> {
    @Query("SELECT s FROM SellerCompanyInfo s WHERE s.sellerCompanyTaxCode = ?1")
    List<SellerCompanyInfo> findBySellerCompanyTaxCode(String taxId);

}