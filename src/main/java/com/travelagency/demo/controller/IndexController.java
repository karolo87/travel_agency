package com.travelagency.demo.controller;

import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.service.ContinentService;
import com.travelagency.demo.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequiredArgsConstructor
public class IndexController {

    private TripService tripService;
    private ContinentService continentService;

    @Autowired
    public IndexController(TripService tripService,
                           ContinentService continentService) {
        this.tripService = tripService;
        this.continentService = continentService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("allTrips", tripService.getAllTrips());
        model.addAttribute("promotedTrips", tripService.getPromotedTrips());
        model.addAttribute("allContinents", continentService.getAllContinentsSortedByName());
        model.addAttribute("firstMinute", tripService.getTripsOrderedByStartDateDesc().subList(0, 3));
        model.addAttribute("lastMinute", tripService.getTripsOrderedByStartDateAsc().subList(0, 3));

        return "index";
    }
}
