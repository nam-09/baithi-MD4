package com.example.citytour.service;

import com.example.citytour.model.City;

import java.util.List;

public interface ICityService extends IGenerateService<City> {
    List<City> findByNameContaining(String name);
}
