package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByCountry_Id(Long id);
}
