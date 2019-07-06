package com.travelagency.demo.controller;

import com.travelagency.demo.dto.TripPurchaseDto;
import com.travelagency.demo.service.TripPurchaseService;
import com.travelagency.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TripPurchaseController {

    private TripPurchaseService tripPurchaseService;
    private TripService tripService;

    @Autowired
    public TripPurchaseController(TripPurchaseService tripPurchaseService,
                                  TripService tripService) {
        this.tripPurchaseService = tripPurchaseService;
        this.tripService = tripService;
    }


    @GetMapping("/buy-a-trip/{tripId}")
    public String buyATrip(@PathVariable("tripId") Long tripId,
                           Model model) {
        model.addAttribute("trip", tripService.getTripById(tripId).get());
        model.addAttribute("newTripPurchase", new TripPurchaseDto());
        return "trip-purchase/buy";
    }

    @PostMapping("/buy-a-trip/{tripId}")
    public String buyATripPost(@PathVariable("tripId") Long tripId,
                               @ModelAttribute("newTripPurchase") TripPurchaseDto tripPurchaseDto) {
        tripPurchaseService.createPurchaseFromDto(tripId, tripPurchaseDto);
        return "trip-purchase/purchase-summary";
    }

    @GetMapping("/purchase-summary/{clientId}")
    public String showYourPurchase(@PathVariable("clientId") Long id,
            Model model) {
        model.addAttribute("yourPurchase", tripPurchaseService.getTripPurchaseById(id));
        return "trip-purchase/purchase-summary";
    }

}
