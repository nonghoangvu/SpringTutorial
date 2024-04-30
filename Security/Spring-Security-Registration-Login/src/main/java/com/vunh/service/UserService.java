package com.vunh.service;

import com.vunh.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserAccountRepository userAccountRepository;
}
