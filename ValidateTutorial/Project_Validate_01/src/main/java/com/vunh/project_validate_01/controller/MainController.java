package com.vunh.project_validate_01.controller;

import com.vunh.project_validate_01.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping
    String index(@Validated @ModelAttribute("user") User user, BindingResult result, Model model) {
        System.out.println(user.getUsername());
        return "index";
    }
}
