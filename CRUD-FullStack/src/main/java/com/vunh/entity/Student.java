package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Please enter your name")
    @Nationalized
    @Column(name = "full_name", length = 50)
    private String fullName;

    @NotNull(message = "Please enter your age")
    @Min(value = 18, message = "Age must be over 18 years old!")
    @Column(name = "age")
    private Integer age;

    @NotNull(message = "Please declare your gender :)")
    @Column(name = "gender")
    private Boolean gender;

}