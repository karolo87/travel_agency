package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.domain.repository.TripRepository;

import com.travelagency.demo.dto.TripDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripService {

    private TripRepository tripRepository;
    private CountryService countryService;
    private CityService cityService;
    private AirportService airportService;
    private HotelService hotelService;

    @Autowired
    public TripService(TripRepository tripRepository,
                       CountryService countryService,
                       CityService cityService,
                       AirportService airportService,
                       HotelService hotelService) {
        this.tripRepository = tripRepository;
        this.countryService = countryService;
        this.cityService = cityService;
        this.airportService = airportService;
        this.hotelService = hotelService;
    }

    public Trip addNewTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public List<Trip> getAllTripsToGivenCountry(Long countryId) {
        return tripRepository.findAllByArrivalCity_Country_Id(countryId);
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    public List<Trip> getPromotedTrips() {
        String isPromoted = "Tak";
        return tripRepository.findByIsPromotedLike("Tak");
    }

    public List<Trip> getAllTripsOfGivenContinent(Long continentId) {
        return tripRepository.findAllByArrivalCity_Country_Continent_Id(continentId);
    }

    public Trip createTripFromDto(TripDto tripDto) {
        Trip trip = new Trip();
        trip.setDepartureCity(cityService.findCityByName(tripDto.getDepartureCity()));
        trip.setDepartureAirport(airportService.findByName(tripDto.getDepartureAirport()));
        trip.setArrivalCity(cityService.findCityByName(tripDto.getArrivalCity()));
        trip.setArrivalAirport(airportService.findByName(tripDto.getArrivalAirport()));
        trip.setHotel(hotelService.findByName(tripDto.getHotel()));
        trip.setStartDate(LocalDate.parse(tripDto.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-d")));
        trip.setEndDate(LocalDate.parse(tripDto.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-d")));
        trip.setDaysQuantity(tripDto.getDaysQuantity());
        trip.setType(tripDto.getType());
        trip.setAdultPrice(tripDto.getAdultPrice());
        trip.setChildPrice(tripDto.getChildPrice());
        trip.setAdultsQuantity(tripDto.getAdultsQuantity());
        trip.setChildrenQuantity(tripDto.getChildrenQuantity());
        trip.setIsPromoted(tripDto.getIsPromoted());

        return tripRepository.save(trip);
    }

}
