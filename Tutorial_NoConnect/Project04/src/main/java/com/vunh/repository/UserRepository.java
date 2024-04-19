package com.vunh.repository;

import com.vunh.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList;

    public UserRepository(){
        this.userList = new ArrayList<>();
        this.userList.add(new User("NongHoangVu", "123", "Admin"));
        this.userList.add(new User("admin", "123", "client"));
        this.userList.add(new User("customer", "123", "client"));
    }

    public List<User> getAll() {
        return this.userList;
    }

    public void add(User user){
        this.userList.add(user);
    }
}
