package com.vunh.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Product name cannot be null")
    @Size(min = 1, max = 255, message = "Product name must be between 1 and 255 characters")
    @Column(name = "product_name")
    private String productName;

    @NotNull(message = "Price cannot be null")
    @PositiveOrZero(message = "Price must be a positive number or zero")
    @Column(name = "price")
    private Integer price;

    @Size(max = 1000, message = "Description must be between 1 and 1000 characters")
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_image")
    private Image image;

    @Column(name = "create_date")
    private Date createDate = new Date();
}
