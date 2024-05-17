package com.vunh.service;

import com.vunh.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<User> getAllUsers() {
        return List.of(
                new User("user", "123", "USER"),
                new User("admin", "123", "ADMIN")
        );
    }
}