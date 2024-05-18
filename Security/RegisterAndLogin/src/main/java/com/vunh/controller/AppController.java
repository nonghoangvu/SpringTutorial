package com.vunh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/register")
    public String signup() {
        return "account/register";
    }

    @PostMapping("/register")
    public String register() {
        System.out.println("Save");
        return "redirect:/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/index";
    }

    @GetMapping("/user")
    public String user() {
        return "user/index";
    }
}
