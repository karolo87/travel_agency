package com.travelagency.demo.controller;

import com.travelagency.demo.domain.model.Continent;
import com.travelagency.demo.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContinentController {

    private ContinentService continentService;

    @Autowired
    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping("/admin/add-continent")
    public String addContinent(Model model){
        model.addAttribute("newContinent", new Continent());
        return "continent/add-continent";
    }

    @PostMapping("/admin/add-continent")
    public String addContinentPost(@ModelAttribute("newContinent") Continent continent) {
        continentService.addNewContinent(continent);
        return "redirect:/continent/list";
    }

    @GetMapping("/continent/list")
    public String getAllContinents(Model model) {
        model.addAttribute("continentList", continentService.getAllContinents());
        return "continent/list";
    }
}
