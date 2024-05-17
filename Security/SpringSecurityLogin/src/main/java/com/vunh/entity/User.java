package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @Nationalized
    @Column(name = "username", length = 30)
    private String username;

    @Size(max = 200)
    @Nationalized
    @Column(name = "password", length = 200)
    private String password;

    @Size(max = 20)
    @Nationalized
    @Column(name = "role", length = 20)
    private String role;

}