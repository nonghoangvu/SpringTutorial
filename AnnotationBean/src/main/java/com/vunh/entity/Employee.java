package com.vunh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;

    public void init() {
        System.out.println("Init: do something");
    }

    public void destroy() {
        System.out.println("Destroy: do something");
    }
}
