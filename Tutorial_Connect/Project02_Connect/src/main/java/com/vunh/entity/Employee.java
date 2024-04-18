package com.vunh.entity;


import com.vunh.exception.ValidDateOfBirth;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "You must enter your name first!")
    @Size(min = 5, max = 50, message = "Name must be in the range of 5 to 50 characters")
    @Column(name = "fullname", nullable = false)
    private String fullName;

    @NotNull(message = "Please specify the gender")
    @Column(name = "gender", nullable = false)
    private Boolean gender;

    @NotNull(message = "Please specify the date of birth")
    @ValidDateOfBirth(message = "Date of birth must be before the current date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @NotNull(message = "Please specify the country")
    @ManyToOne
    @JoinColumn(name = "id_country", nullable = false)
    private Country country;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date", nullable = false)
    private Date createDate;
}
