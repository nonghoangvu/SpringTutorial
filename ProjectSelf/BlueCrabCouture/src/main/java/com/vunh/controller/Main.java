package com.vunh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main {
    @GetMapping
    String index(){
        return "index";
    }
}
