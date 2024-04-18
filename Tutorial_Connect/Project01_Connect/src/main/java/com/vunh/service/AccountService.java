package com.vunh.service;

import com.vunh.entity.Account;
import com.vunh.entity.Role;
import com.vunh.repository.AccountRepository;
import com.vunh.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<Account> getAll() {
        return this.accountRepository.findAll();
    }
    public Page<Account> getAll(Pageable pageable) {
        return this.accountRepository.findAll(pageable);
    }

    public List<Role> getRole() {
        return this.roleRepository.findAll();
    }

    public void saveOrUpdate(Account account) {
        this.accountRepository.save(account);
    }

    public Account findById(int id) {
        Optional<Account> account = this.accountRepository.findById(id);
        return account.orElseGet(Account::new);
    }

    public void delete(Account account) {
        this.accountRepository.delete(account);
    }

    public Boolean existByUsername(String username) {
        return this.accountRepository.findByUsername(username) == null;
    }

}
