package com.example.citytour.controller;

import com.example.citytour.model.City;
import com.example.citytour.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {
    @Autowired
    public ICityService cityService;

    @GetMapping("")
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody City city) {
        cityService.save(city);
        String message = "Added successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        cityService.save(city);
        String message = "Edited successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        cityService.remove(id);
        String message = "Deleted successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        City city = cityService.findById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<City>> search(@Param("name") String name) {
        List<City> list = cityService.findByNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
