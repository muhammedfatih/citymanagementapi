package com.mfatih.citymanagementapi.specifications;

import com.mfatih.citymanagementapi.models.City;
import org.springframework.data.jpa.domain.Specification;

public class CitySpecifications {
    public static Specification<City> nameContains(String name) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }
}
