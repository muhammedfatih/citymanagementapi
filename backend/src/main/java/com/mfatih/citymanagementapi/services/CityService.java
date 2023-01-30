package com.mfatih.citymanagementapi.services;

import com.mfatih.citymanagementapi.models.City;
import com.mfatih.citymanagementapi.repositories.CityRepository;
import com.mfatih.citymanagementapi.specifications.CitySpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City save(City city) {
        return cityRepository.save(city);
    }

    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    public City update(City city, Long id) {
        City existingCity = cityRepository.findById(id).get();
        existingCity.setName(city.getName());
        existingCity.setPhotoUrl(city.getPhotoUrl());
        return cityRepository.save(existingCity);
    }

    public Page<City> findAll(int page, int size, String name) {
        Pageable pageable = PageRequest.of(page, size);
        return cityRepository.findAll(CitySpecifications.nameContains(name), pageable);
    }
}
