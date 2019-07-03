package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.Airport;
import com.travelagency.demo.domain.model.City;
import com.travelagency.demo.domain.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private AirportRepository airportRepository;
    private CityService cityService;

    @Autowired
    public AirportService(AirportRepository airportRepository,
                          CityService cityService) {
        this.airportRepository = airportRepository;
        this.cityService = cityService;
    }

    public void addNewAirport(Long cityId, Airport airport) {
        Optional<City> foundCity = cityService.findCityById(cityId);
        foundCity.ifPresent(airport::setCity);
        airportRepository.save(airport);
    }

    public List<Airport> getAllAirportsOfGivenCity(Long cityId) {
        return airportRepository.findAllByCity_Id(cityId);
    }
}
