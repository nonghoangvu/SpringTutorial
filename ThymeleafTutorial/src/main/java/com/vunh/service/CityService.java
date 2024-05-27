package com.vunh.service;

import com.vunh.entity.City;
import com.vunh.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return this.cityRepository.findAll();
    }
}
