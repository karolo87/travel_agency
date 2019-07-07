package com.travelagency.demo.controller;

import com.travelagency.demo.service.ContinentService;
import com.travelagency.demo.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "index";
    }

}
