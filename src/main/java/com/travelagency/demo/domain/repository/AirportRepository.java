package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findAllByCity_Id(Long cityId);
    Airport findByNameContaining(String name);
}
