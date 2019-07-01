package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
