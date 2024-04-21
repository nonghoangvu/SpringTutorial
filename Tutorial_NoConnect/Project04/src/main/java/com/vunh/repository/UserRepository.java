package com.vunh.repository;

import com.vunh.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
        this.userList.add(new User("NongHoangVu", "123", "Admin"));
        this.userList.add(new User("admin", "123", "Client"));
        this.userList.add(new User("customer", "123", "Client"));
    }

    public List<User> getAll() {
        return this.userList;
    }

    public void add(User user) {
        this.userList.add(user);
    }

    public void delete(String username){
        this.userList.removeIf(user -> user.getUsername().equalsIgnoreCase(username));
    }
}
