package com.vunh.security;

import com.vunh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserService userService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        PasswordEncoder encoder = passwordEncoder();
        List<UserDetails> list = userService.getAllUsers().stream()
                .map(user -> org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsername())
                        .password(encoder.encode(user.getPassword()))
                        .roles(user.getRole())
                        .build())
                .collect(Collectors.toList());
        return new InMemoryUserDetailsManager(list);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hacker/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
                ).formLogin(login -> login.loginProcessingUrl("/login").defaultSuccessUrl("/hacker"))//Using loginPage if login exists
                .exceptionHandling(ex -> ex.accessDeniedPage("/login"));//Using loginPage if login exists
        return http.build();
    }
}
