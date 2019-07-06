package com.travelagency.demo.controller;

import com.travelagency.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private TripService tripService;

    @Autowired
    public IndexController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("allTrips", tripService.getAllTrips());
        return "index";
    }

}
