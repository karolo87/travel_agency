package com.travelagency.demo.controller;

import com.travelagency.demo.domain.model.Continent;
import com.travelagency.demo.domain.model.Country;
import com.travelagency.demo.service.ContinentService;
import com.travelagency.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.function.Consumer;

@Controller
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/admin/add-country/{continentId}")
    public String addCountry(@PathVariable("continentId") Long id,
                                         Model model) {
        model.addAttribute("continentId", id);
        model.addAttribute("newCountry", new Country());
        return "country/add-country";
    }

    @PostMapping("/admin/add-country/{continentId}")
    public String addCountryPost(@PathVariable("continentId") Long id,
            @ModelAttribute("newCountry") Country country) {
        countryService.addNewCountry(id, country);
        return "redirect:/country/list/{continentId}";
    }

    @GetMapping("/country/list/{continentId}")
    public String getAllCountriesOfGivenContinent(@PathVariable("continentId") Long id,
                                                  Model model){
        List<Country> foundCountries = countryService.getAllCountrierOfGivenContinent(id);
        model.addAttribute("countries_of_continent", foundCountries);
        return "country/list";

    }
}

