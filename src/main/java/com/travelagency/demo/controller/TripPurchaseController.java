package com.travelagency.demo.controller;

import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.domain.model.TripPurchase;
import com.travelagency.demo.dto.PageForm;
import com.travelagency.demo.dto.TripPurchaseDto;
import com.travelagency.demo.service.TripPurchaseService;
import com.travelagency.demo.service.TripService;
import com.travelagency.demo.validator.TripPurchaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Trip trip = tripService.getTripById(tripId).get();
        TripPurchaseDto dto = new TripPurchaseDto();

        model.addAttribute("trip", trip);
        model.addAttribute("newTripPurchase", dto);
        dto.setAdultsAvailable(String.valueOf(trip.getAdultsQuantity()));
        dto.setChildrenAvailable(String.valueOf(trip.getChildrenQuantity()));
        dto.setAdultsQuantity("2");
        dto.setChildrenQuantity("0");
        return "trip-purchase/buy";
    }

    @PostMapping("/buy-a-trip/{tripId}")
    public String buyATripPost(@PathVariable("tripId") Long tripId,
                               @ModelAttribute("newTripPurchase") TripPurchaseDto tripPurchaseDto,
                               Model model, BindingResult bindingResult) {
        Trip trip = tripService.getTripById(tripId).get();
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

    @GetMapping("/admin/purchase-list")
    public String getAllPurchases(Model model) {
        model.addAttribute("pageForm", new PageForm());
        model.addAttribute("purchaseList", tripPurchaseService.getAllTripPurchases());
        return "trip-purchase/list";
    }

    @PostMapping("/admin/purchase-list")
    public String getAllPurchasesPost(@ModelAttribute("pageForm") PageForm pageForm, Model model) {
        Pageable pageable = PageRequest.of(pageForm.getPage(),
                pageForm.getSize(),
                pageForm.getSortOrder(),
                pageForm.getSortField());
        Page<TripPurchase> allTripPurchases = tripPurchaseService.getAllTripPurchases(pageable);
        model.addAttribute("purchaseList", allTripPurchases);
        return "/admin/purchase-list";
    }
}
