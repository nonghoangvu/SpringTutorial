package com.vunh.config;

import com.vunh.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public User getUser() {
        User user = new User();
        user.setUsername("vunh");
        return user;
    }
}
