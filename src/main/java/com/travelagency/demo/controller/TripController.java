package com.travelagency.demo.controller;

import com.travelagency.demo.domain.model.City;
import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.service.CityService;
import com.travelagency.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TripController {

    private TripService tripService;
    private CityService cityService;

    @Autowired
    public TripController(TripService tripService,
                          CityService cityService) {
        this.tripService = tripService;
        this.cityService = cityService;
    }

    @GetMapping("/admin/add-trip")
    public String addNewTrip(Model model) {
        model.addAttribute("newTrip", new Trip());

        return "trip/add-trip";
    }

    @PostMapping("/admin/add-trip")
    public String addNewTripPost(@ModelAttribute("newTrip") Trip trip) {
        tripService.addNewTrip(trip);
        return "redirect:/trip/list";
    }

    @GetMapping("/trip/list")
    public String getAllTrips(Model model) {
        model.addAttribute("tripsList", tripService.getAllTrips());
        return "trip/list";
    }
}
