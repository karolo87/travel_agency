package com.travelagency.demo.controller;

import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.service.CityService;
import com.travelagency.demo.dto.TripDto;
import com.travelagency.demo.service.AirportService;
import com.travelagency.demo.service.HotelService;
import com.travelagency.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Controller
public class TripController {

    private TripService tripService;
    private CityService cityService;
    private AirportService airportService;
    private HotelService hotelService;


    @Autowired
    public TripController(TripService tripService,
                          CityService cityService,
                          AirportService airportService,
                          HotelService hotelService) {
        this.tripService = tripService;
        this.cityService = cityService;
        this.airportService = airportService;
        this.hotelService = hotelService;
    }

    @GetMapping("/admin/add-trip")
    public String addNewTrip(Model model) {
        model.addAttribute("newTrip", new Trip());
        model.addAttribute("newTrip", new TripDto());
        return "trip/add-trip";
    }

    @PostMapping("/admin/add-trip")
    public String addNewTripPost(@ModelAttribute("newTrip") TripDto tripDto) {
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
        tripService.addNewTrip(trip);
        return "redirect:/trip/list";
    }

    @GetMapping("/trip/list")
    public String getAllTrips(Model model) {
        model.addAttribute("tripsList", tripService.getAllTrips());
        return "trip/list";
    }
}
