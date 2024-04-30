package com.vunh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping
    String index(){
        return "index";
    }
    @GetMapping("/admin/home")
    String viewAdmin(){
        return "admin";
    }
    @GetMapping("/user/home")
    String viewUser(){
        return "user";
    }
}
