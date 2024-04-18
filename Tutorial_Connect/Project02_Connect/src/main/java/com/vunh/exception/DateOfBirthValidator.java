package com.vunh.exception;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Date;
import java.util.Optional;

public class DateOfBirthValidator implements ConstraintValidator<ValidDateOfBirth, Date> {

    @Override
    public void initialize(ValidDateOfBirth constraintAnnotation) {
    }

    @Override
    public boolean isValid(Date dateOfBirth, ConstraintValidatorContext context) {
        Date currentDate = new Date();
        if (dateOfBirth == null) {
            return false;
        }
        return dateOfBirth.before(currentDate);
    }
}
