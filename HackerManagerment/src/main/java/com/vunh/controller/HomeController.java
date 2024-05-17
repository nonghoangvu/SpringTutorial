package com.vunh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping
    @ResponseBody
    String index(){
        return "<a href='/hacker'>Click Me</a>";
    }
}
