package com.example.citytour.service;

import com.example.citytour.model.City;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
