package com.vunh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    private CityRepository CityRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cityList", CityRepository.findAll());
        return "index";
    }
}
