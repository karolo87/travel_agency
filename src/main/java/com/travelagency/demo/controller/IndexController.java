package com.travelagency.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

}
