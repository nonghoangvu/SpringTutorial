package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "Account")
@Data
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Username is empty!")
    @Column(name = "username", unique = true)
    private String username;

    @Size(min = 5, max = 100, message = "The password in a range 5 to 10!")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "You must enter your name first!")
    @Column(name = "fullName")
    private String fullname;

    @NotNull(message = "Role is required!")
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
}
