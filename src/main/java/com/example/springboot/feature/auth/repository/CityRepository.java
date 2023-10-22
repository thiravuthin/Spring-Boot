package com.example.springboot.feature.auth.repository;

import com.example.springboot.feature.auth.domain.City;
import com.example.springboot.feature.auth.domain.CityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, CityId> {

    @Query("SELECT c FROM City c WHERE c.id.nationalCode = ?1 AND c.id.countryCode = ?2")
    Optional<City> findByNationalCodeAndName(String nationalCode, String countryCode);

    @Query("SELECT c FROM City c WHERE c.id.nationalCode = ?1")
    List<City> findByNationalCode(String nationalCode);


}