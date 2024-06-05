package com.example.citytour.service.impl;

import com.example.citytour.model.Country;
import com.example.citytour.repository.CountryRepository;
import com.example.citytour.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CountryService implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }
    public Country findById(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) {
            return country.get(); }
        else return null;

    }
    public void save(Country country) {
        countryRepository.save(country);
    }
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
    public List<Country> findByNameContaining(String name) {
        return countryRepository.findByNameContaining(name);
    }
}
