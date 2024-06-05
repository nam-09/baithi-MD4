package com.example.citytour.service.impl;

import com.example.citytour.model.City;
import com.example.citytour.model.Country;
import com.example.citytour.repository.CityRepository;
import com.example.citytour.service.ICityService;
import com.example.citytour.service.IGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepository cityRepository;
    public List<City> findAll() {
        return cityRepository.findAll();
    }
    public City findById(Long id) {
        Optional<City> order = cityRepository.findById(id);
        if (order.isPresent()) {
            return order.get(); }
        else return null;

    }
    public void save(City city) {
        cityRepository.save(city);
    }
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }
    public List<City> findByNameContaining(String name) {
        return cityRepository.findByNameContaining(name);
    }

}
