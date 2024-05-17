package com.vunh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/home")
    String index(){
        return "index";
    }

    @GetMapping("/admin")
    String admin(){
        return "admin";
    }

    @GetMapping("/login")
    String login(){
        return "login";
    }
}
