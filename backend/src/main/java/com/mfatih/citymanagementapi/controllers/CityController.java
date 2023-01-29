package com.mfatih.citymanagementapi.controllers;

import com.mfatih.citymanagementapi.models.City;
import com.mfatih.citymanagementapi.repositories.CityRepository;
import com.mfatih.citymanagementapi.specifications.CitySpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
    public Page<City> getCities(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(required = false) String name) {
        Pageable pageable = PageRequest.of(page, size);
        return cityRepository.findAll(CitySpecifications.nameContains(name), pageable);
    }
    @PutMapping("/cities")
    void updateCity(@RequestBody City city) {
        cityRepository.save(city);
    }
}
