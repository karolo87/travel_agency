package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.City;
import com.travelagency.demo.domain.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByArrivalCity_Country_Id(Long countryId);

    Trip findByDepartureCity_NameContaining(String departureCityName);
    Trip findByDepartureAirport_NameContaining(String departureAirportName);
    Trip findByArrivalCity_NameContaining(String arrivalCityName);
    Trip findByArrivalAirport_NameContaining(String arrivalAirportName);
    Trip findByHotel_NameContaining(String hotelName);
}
