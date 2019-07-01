package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
