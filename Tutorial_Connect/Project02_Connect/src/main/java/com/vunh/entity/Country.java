package com.vunh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "country")
    private String country;
}
