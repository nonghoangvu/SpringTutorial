package com.vunh.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Role")
@Data
public class Role {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_key")
    private String roleKey;
}
