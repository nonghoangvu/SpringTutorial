package com.vunh.controller;

import com.vunh.entity.Hacker;
import com.vunh.service.HackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("hacker")
public class AppController {
    @Autowired
    private HackerService hackerService;

    @GetMapping
    String index(Model model, @RequestParam("keyword") Optional<String> keyword) {
        model.addAttribute("hacker", new Hacker());
        model.addAttribute("hackers", this.hackerService.getHackers(keyword.orElse("")));
        model.addAttribute("keyword", keyword.orElse(""));
        model.addAttribute("listMajor", this.hackerService.getListMajor());
        return "index";
    }

    @PostMapping("store")
    String store(@Validated @ModelAttribute("hacker") Hacker hacker, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("hacker", hacker);
            model.addAttribute("hackers", this.hackerService.getHackers());
            model.addAttribute("listMajor", this.hackerService.getListMajor());
            return "index";
        } else {
            this.hackerService.storeHacker(hacker);
            return "redirect:/hacker";
        }
    }

    @GetMapping("/{id}")
    String edit(@PathVariable int id, Model model) {
        model.addAttribute("hacker", this.hackerService.findHacker(id));
        model.addAttribute("hackers", this.hackerService.getHackers());
        model.addAttribute("listMajor", this.hackerService.getListMajor());
        return "index";
    }

    @PostMapping("update")
    String update(@Validated @ModelAttribute("hacker") Hacker hacker, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("hacker", hacker);
            model.addAttribute("hackers", this.hackerService.getHackers());
            model.addAttribute("listMajor", this.hackerService.getListMajor());
            return "index";
        } else {

            this.hackerService.updateHacker(hacker);
            return "redirect:/hacker";
        }
    }

    @GetMapping("delete/{id}")
    String delete(@PathVariable int id) {
        this.hackerService.deleteHacker(id);
        return "redirect:/hacker";
    }
}
