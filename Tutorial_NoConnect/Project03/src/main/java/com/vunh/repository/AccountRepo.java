package com.vunh.repository;

import com.vunh.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountRepo {
    private List<Account> list;

    public AccountRepo() {
        this.list = new ArrayList<>();
        this.list.add(new Account(1, "admin", "123", "Nong Hoang Vu", 1));
        this.list.add(new Account(2, "client", "123", "Not found", 0));
    }

    public List<Account> findAll() {
        return this.list;
    }

    public void save(Account account) {
        this.list.add(account);
    }

    public void delete(int id) {
        this.list.removeIf(a -> a.getId() == id);
    }

    public Account findById(int id) {
        return this.list.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public void update(Account account) {
        this.list.stream().filter(a -> a.getId() == account.getId()).toList().forEach(s -> {
            s.setFullName(account.getFullName());
            s.setUsername(account.getUsername());
            s.setPassword(account.getPassword());
            s.setRole(account.getRole());
        });

    }
}
