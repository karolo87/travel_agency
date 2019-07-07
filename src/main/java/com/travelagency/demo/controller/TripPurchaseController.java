package com.travelagency.demo.controller;

import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.domain.model.TripPurchase;
import com.travelagency.demo.dto.TripPurchaseDto;
import com.travelagency.demo.service.TripPurchaseService;
import com.travelagency.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
                               @ModelAttribute("newTripPurchase") TripPurchaseDto tripPurchaseDto,
                               Model model){
        TripPurchase purchase = tripPurchaseService.createPurchaseFromDto(tripId, tripPurchaseDto);
        model.addAttribute("purchaseId", purchase.getId());
        return "redirect:/purchase/purchase-summary";
    }

    @GetMapping("/purchase/purchase-summary")
    public String showYourPurchase(@ModelAttribute("newTripPurchase") TripPurchase tripPurchase,
            Model model) {
//        model.addAttribute("newTripPurchase", tripPurchaseService.getTripPurchaseById(purchaseId));
        return "trip-purchase/purchase-summary";
    }

    @PostMapping("/purchase/purchase-summary")
    public String showYourPurchasePost() {

        return "trip-purchase/purchase-summary";
    }

}
