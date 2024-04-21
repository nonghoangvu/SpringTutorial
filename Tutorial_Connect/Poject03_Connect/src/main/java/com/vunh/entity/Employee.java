package com.vunh.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @Column(name = "create_date")
    private Date createDate;
}
