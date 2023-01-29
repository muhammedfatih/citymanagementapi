package com.mfatih.citymanagementapi.controllers;

import com.mfatih.citymanagementapi.models.City;
import com.mfatih.citymanagementapi.repositories.CityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@CrossOrigin
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @GetMapping("/cities")
    public List<City> getCities() {
        return (List<City>) cityRepository.findAll();
    }

    @PutMapping("/cities")
    void updateCity(@RequestBody City city) {
        cityRepository.save(city);
    }
}
