package com.vunh.controller;

import com.vunh.entity.Account;
import com.vunh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestAPI {
    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    List<Account> index(@RequestParam("page") Optional<Integer> page, Optional<Integer> limit) {
        Pageable pageable = PageRequest.of(page.orElse(0), limit.orElse(5));
        Page<Account> accounts = accountService.getAll(pageable);
        return accounts.getContent();
    }
}
