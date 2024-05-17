package com.vunh.exception;

import jakarta.validation.*;

import java.lang.annotation.*;
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AlreadyExistValidate.class})
public @interface AlreadyExist {
    String message() default "This ID already exists, please enter another ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
