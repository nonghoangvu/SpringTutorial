package com.vunh.controller;

import com.vunh.entity.Account;
import com.vunh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    String pagination(Model model, @RequestParam("page") Optional<Integer> page, Optional<Integer> limit) {
        Pageable pageable = PageRequest.of(page.orElse(0), limit.orElse(5));
        Page<Account> accounts = accountService.getAll(pageable);
        model.addAttribute("ACCOUNTS", accounts);
        model.addAttribute("limit", limit.orElse(5));
        return "index";
    }

    @GetMapping("/create")
    String create(Model model) {
        model.addAttribute("ACCOUNT", new Account());
        model.addAttribute("ROLES", this.accountService.getRole());
        return "create";
    }

    @PostMapping("/create")
    String store(@Validated @ModelAttribute("ACCOUNT") Account account, BindingResult result, Model model) {
        /*
         * if username exists then result.rejectValue will add an error to BindingResult
         * for username. When have an error in BindingResult, condition result.hasErrors return true
         * then render to create.
         * */
        if (!this.accountService.existByUsername(account.getUsername())) {
            result.rejectValue("username", "username.exists", "Username already exists!");
        }
        if (result.hasErrors()) {
            model.addAttribute("ACCOUNT", account);
            model.addAttribute("ROLES", this.accountService.getRole());
            return "create";
        }
        this.accountService.saveOrUpdate(account);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") int id) {
        this.accountService.delete(this.accountService.findById(id));
        return "redirect:/";
    }

    @GetMapping("/update")
    String edits(@RequestParam("id") int id, Model model) {
        Account account = this.accountService.findById(id);
        model.addAttribute("ACCOUNT", account);
        model.addAttribute("ROLES", this.accountService.getRole());
        return "edit";
    }

    @PostMapping("/update")
    String update(@RequestParam("id") int id, @RequestParam("name") String username, @Validated @ModelAttribute("ACCOUNT") Account account, BindingResult result, Model model) {
        account.setId(id);
        if (!username.trim().equalsIgnoreCase(account.getUsername().trim())) {
            if (!this.accountService.existByUsername(account.getUsername())) {
                result.rejectValue("username", "username.exists", "Username already exists!");
            }
        }
        if (result.hasErrors()) {
            account.setUsername(username);
            model.addAttribute("name", username);
            model.addAttribute("ACCOUNT", account);
            model.addAttribute("ROLES", this.accountService.getRole());
            return "edit";
        }
        account.setUsername(account.getUsername());
        this.accountService.saveOrUpdate(account);
        return "redirect:/";
    }
}
