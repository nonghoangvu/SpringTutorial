package com.vunh;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String username;
    private String password;
}
