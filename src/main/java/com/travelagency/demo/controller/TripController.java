package com.travelagency.demo.controller;

import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.domain.model.TripPurchase;
import com.travelagency.demo.dto.SearchTrip;
import com.travelagency.demo.service.CityService;
import com.travelagency.demo.dto.TripDto;
import com.travelagency.demo.service.AirportService;
import com.travelagency.demo.service.HotelService;
import com.travelagency.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
        model.addAttribute("newTrip", new TripDto());
        model.addAttribute("cities", cityService.getAllCities());
        return "trip/add-trip";
    }

    @PostMapping("/admin/add-trip")
    public String addNewTripPost(@ModelAttribute("newTrip") TripDto tripDto) {
        tripService.createTripFromDto(tripDto);
        return "redirect:/trip/list";
    }

    @GetMapping("/admin/edit-trip/{tripId}")
    public String editTrip(@PathVariable("tripId") Long id, Model model) {
        Trip trip = tripService.getTripById(id).get();
        if (tripService.getTripById(id).isPresent()) {
            TripDto editedTrip = tripService.createTripDtoFromTrip(trip);
            model.addAttribute("editedTrip", editedTrip);
            model.addAttribute("cities", cityService.getAllCities());
            return "trip/edit";
        }
        return "redirect:/admin/add-trip";
    }

    @PostMapping("/admin/edit-trip/{tripId}")
    public String editTripPost(@PathVariable("tripId") Long id,
                               @ModelAttribute("editedTrip") TripDto tripDto) {
        Trip trip = tripService.createTripFromDto(tripDto);
        tripService.addNewTrip(trip);
        return "redirect:/trip/details/{tripId}";
    }

    @GetMapping("/trip/details/{tripId}")
    public String showDetailsOfGivenTrip(@PathVariable("tripId") Long tripId,
                                         Model model) {
        model.addAttribute("trip", tripService.getTripById(tripId).get());
        model.addAttribute("newPurchase", new TripPurchase());
        return "trip/details";
    }

    @GetMapping("/search")
    public String searchATrip(Model model) {
        model.addAttribute("searchedTrip", new SearchTrip());
        return "trip/search";
    }

    @PostMapping("/search")
    public String searchATrip(@ModelAttribute("searchedTrip") SearchTrip searchTrip,
                              Model model) {

        String param = searchTrip.getParam();
        String value = searchTrip.getValue();
        model.addAttribute("foundTrips", tripService.findATrip(param, value));

        return "trip/search-result";
    }


    @GetMapping("/trip/list")
    public String getAllTrips(Model model) {
        model.addAttribute("tripsList", tripService.getAllTrips());
        return "trip/list";
    }

}
