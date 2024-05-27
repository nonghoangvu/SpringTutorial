package com.vunh.controller;

import com.vunh.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        return "index";
    }

    @GetMapping("/goto")
    public String gotoPage(Model model) {
        model.addAttribute("data", this.cityService.findAll());
        return "data/index";
    }
}
