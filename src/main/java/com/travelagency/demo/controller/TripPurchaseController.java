package com.travelagency.demo.controller;

import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.domain.model.TripPurchase;
import com.travelagency.demo.dto.TripPurchaseDto;
import com.travelagency.demo.service.TripPurchaseService;
import com.travelagency.demo.service.TripService;
import com.travelagency.demo.validator.TripPurchaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class TripPurchaseController {

    private TripPurchaseService tripPurchaseService;
    private TripService tripService;
    private TripPurchaseValidator tripPurchaseValidator;

    @Autowired
    public TripPurchaseController(TripPurchaseService tripPurchaseService,
                                  TripService tripService,
                                  TripPurchaseValidator tripPurchaseValidator) {
        this.tripPurchaseService = tripPurchaseService;
        this.tripService = tripService;
        this.tripPurchaseValidator = tripPurchaseValidator;
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
                               Model model, BindingResult bindingResult) {
        tripPurchaseValidator.validate(tripPurchaseDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult);
            return "trip-purchase/buy";
        }
        TripPurchase purchase = tripPurchaseService.createPurchaseFromDto(tripId, tripPurchaseDto);
        model.addAttribute("purchaseId", purchase.getId());
        return "redirect:/purchase/purchase-summary/" + purchase.getId();
    }

    @GetMapping("/purchase/purchase-summary/{purchaseId}")
    public String showYourPurchase(@PathVariable("purchaseId") Long purchaseId,
                                   Model model) {
        model.addAttribute("newTripPurchase", tripPurchaseService.getTripPurchaseById(purchaseId).get());
        model.addAttribute("amountOfMoney", tripPurchaseService.calculateTripPurchaseFinances(purchaseId));
        return "trip-purchase/purchase-summary";
    }

    @PostMapping("/purchase/purchase-summary")
    public String showYourPurchasePost() {

        return "trip-purchase/purchase-summary";
    }

}
