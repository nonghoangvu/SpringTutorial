package com.vunh.config;

import com.vunh.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy", name = "abcOrNameMethodConfig")
    public Employee nameConfigMethod() {
        Employee employee = new Employee();
        employee.setName("Nong Hoang Vu");
        return employee;
    }
}
