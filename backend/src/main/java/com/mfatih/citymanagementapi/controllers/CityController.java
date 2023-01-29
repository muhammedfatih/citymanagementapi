package com.mfatih.citymanagementapi.controllers;

import com.mfatih.citymanagementapi.services.CityService;
import com.mfatih.citymanagementapi.models.City;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/cities")
    public Page<City> getCities(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(defaultValue = "") String name) {
        return cityService.findAll(page, size, name);
    }
    @PutMapping("/cities/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City city) {
        return cityService.update(city, id);
    }
    @GetMapping("/cities/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.findById(id);
    }
}
