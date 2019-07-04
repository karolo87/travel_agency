package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.Country;
import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.domain.repository.TripRepository;
import com.travelagency.demo.dto.TripDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private TripRepository tripRepository;
    private CountryService countryService;

    @Autowired
    public TripService(TripRepository tripRepository,
                       CountryService countryService) {
        this.tripRepository = tripRepository;
        this.countryService = countryService;
    }

    public void addNewTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public List<Trip> getAllTripsToGivenCountry(Long countryId) {
        return tripRepository.findAllByArrivalCity_Country_Id(countryId);
    }

}
