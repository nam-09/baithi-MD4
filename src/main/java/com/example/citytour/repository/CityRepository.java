package com.example.citytour.repository;

import com.example.citytour.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByNameContaining(String name);
}
