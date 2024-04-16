package com.vunh.controller;

import com.vunh.entity.Account;
import com.vunh.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class AccountController {
    @Autowired
    private AccountRepo accountRepo = new AccountRepo();
    @GetMapping()
    String index(Model model){
        model.addAttribute("ACCOUNTS", this.accountRepo.findAll());
        return "index";
    }

    @GetMapping("/create")
    String create(){
        return "create";
    }

    @PostMapping("/store")
    String store(Account account){
        this.accountRepo.save(account);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") int id){
        this.accountRepo.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/edit")
    String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("account", this.accountRepo.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    String update(Account account){
        this.accountRepo.update(account);
        return "redirect:/product";
    }
}
