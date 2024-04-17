package com.vunh.controller;

import com.vunh.entity.Account;
import com.vunh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    String index(Model model) {
        model.addAttribute("ACCOUNTS", accountService.getAll());
        return "index";
    }

    @GetMapping("/create")
    String create(Model model) {
        model.addAttribute("ROLES", this.accountService.getRole());
        return "create";
    }

    @PostMapping("/store")
    String store(@ModelAttribute("ACCOUNT") Account account) {
        this.accountService.saveOrUpdate(account);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") int id) {
        this.accountService.delete(this.accountService.findById(id));
        return "redirect:/";
    }

    @GetMapping("/edit")
    String edits(@RequestParam("id") int id, Model model) {
        Account account = this.accountService.findById(id);
        model.addAttribute("ACCOUNT", account);
        model.addAttribute("ROLES", this.accountService.getRole());
        return "edit";
    }

    @PostMapping("/update")
    String update(@RequestParam("id") int id, @ModelAttribute Account account) {
        account.setId(id);
        this.accountService.saveOrUpdate(account);
        return "redirect:/";
    }
}
