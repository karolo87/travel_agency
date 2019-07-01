package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
