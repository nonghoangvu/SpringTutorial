package com.vunh.project_validate_01.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotBlank(message = "User name is blank!")
    @Size(min = 5, max = 10, message = "The username is in the range 5 to 10")
    private String username;

    @AssertTrue(message = "You must accept to continue!")
    private boolean verify;

    @NotBlank(message = "You must select a relationship!")
    private String relationship;

    @Min(value = 18, message = "Too young!!")
    @Max(value = 30, message = "Out date!!")
    private int age;
}
