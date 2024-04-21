package com.vunh.controller;

import com.vunh.entity.User;
import com.vunh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    String index(Model model) {
        model.addAttribute("listUser", this.userRepository.getAll());
        return "index";//index.jsp
    }

    @GetMapping("/add")
    String create(){
        return "create"; //create.jsp
    }

    @PostMapping("/add")
    String store(@ModelAttribute User user){
        this.userRepository.add(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("username") String username){
        this.userRepository.delete(username);
        return "redirect:/";
    }
}
