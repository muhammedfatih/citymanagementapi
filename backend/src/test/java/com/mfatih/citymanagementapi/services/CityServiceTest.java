package com.mfatih.citymanagementapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mfatih.citymanagementapi.models.City;
import com.mfatih.citymanagementapi.repositories.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {
    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;

    private List<City> cities;
    private Pageable pageable;
    @BeforeEach
    void setUp() {
        cities = new ArrayList<>();
        cities.add(new City("Istanbul", "https://istanbul.jpg"));
        cities.add(new City("London", "https://london.jpg"));
        cities.add(new City("Paris", "https://paris.jpg"));
        cities.add(new City("Berlin", "https://berlin.jpg"));
        pageable = PageRequest.of(0, 10);
    }

    @Test
    void saveTest() {
        City city = cities.get(0);
        when(cityRepository.save(any(City.class))).thenReturn(city);

        City savedCity = cityService.save(city);

        assertNotNull(savedCity);
        assertEquals(city.getName(), savedCity.getName());
        assertEquals(city.getPhotoUrl(), savedCity.getPhotoUrl());
    }

    @Test
    void findByIdTest() {
        City city = cities.get(0);
        when(cityRepository.findById(any(Long.class))).thenReturn(Optional.of(city));

        City foundCity = cityService.findById(city.getId());

        assertNotNull(foundCity);
        assertEquals(city.getName(), foundCity.getName());
        assertEquals(city.getPhotoUrl(), foundCity.getPhotoUrl());
    }

    @Test
    void updateTest() {
        City city = cities.get(0);
        when(cityRepository.findById(any(Long.class))).thenReturn(Optional.of(city));
        when(cityRepository.save(any(City.class))).thenReturn(city);

        City updatedCity = cityService.update(city, city.getId());

        assertNotNull(updatedCity);
        assertEquals(city.getName(), updatedCity.getName());
        assertEquals(city.getPhotoUrl(), updatedCity.getPhotoUrl());
    }

    @Test
    void findAll_WithValidInput_ShouldReturnExpectedPageOfCities() {
        Page<City> expectedResult = new PageImpl<>(cities, pageable, 3);
        when(cityRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(expectedResult);

        Page<City> result = cityService.findAll(0, 10, "");

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void findAll_WithInvalidInput_ShouldReturnEmptyPageOfCities() {
        Page<City> expectedResult = new PageImpl<>(new ArrayList<>(), pageable, 0);
        when(cityRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(expectedResult);

        Page<City> result = cityService.findAll(0, 10, "nonexistent");

        assertThat(result).isEqualTo(expectedResult);
    }
}