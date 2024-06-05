package com.example.citytour.repository;

import com.example.citytour.model.City;
import com.example.citytour.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByNameContaining(String name);
}
