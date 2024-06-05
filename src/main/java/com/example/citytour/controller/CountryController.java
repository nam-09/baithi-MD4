package com.example.citytour.controller;

import com.example.citytour.model.Country;
import com.example.citytour.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    public ICountryService countryService;

    @GetMapping("")
    public ResponseEntity<List<Country>> getAll() {
        List<Country> countries = countryService.findAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Country country) {
        countryService.save(country);
        String message = "Added successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Country country) {
        country.setId(id);
        countryService.save(country);
        String message = "Edited successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        countryService.remove(id);
        String message = "Deleted successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        Country country = countryService.findById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Country>> search(@Param("name") String name) {
        List<Country> list = countryService.findByNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
