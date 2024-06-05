package com.example.citytour.service;

import com.example.citytour.model.City;
import com.example.citytour.model.Country;

import java.util.List;

public interface ICountryService extends IGenerateService<Country> {
    List<Country> findByNameContaining(String name);
}
