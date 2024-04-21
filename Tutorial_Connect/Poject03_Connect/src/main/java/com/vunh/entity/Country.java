package com.vunh.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Country")
@Data
@NoArgsConstructor
public class Country {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "country")
    private String country;
}
