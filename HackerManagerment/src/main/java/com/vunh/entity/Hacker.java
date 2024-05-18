package com.vunh.entity;

import lombok.*;
import jakarta.validation.constraints.*;
import com.vunh.exception.AlreadyExist;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hacker {
    @NotNull
    @Positive
//    @AlreadyExist
    private Integer id;
    @Length(min = 5, max = 50)
    private String fullName;
    @NotNull
    private Boolean gender;
    @NotBlank
    private String major;
}
