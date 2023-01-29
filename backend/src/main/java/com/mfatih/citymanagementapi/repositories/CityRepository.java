package com.mfatih.citymanagementapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mfatih.citymanagementapi.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {}
