package com.vunh.exception;

import com.vunh.service.HackerService;
import jakarta.validation.*;

import java.util.Objects;

public class AlreadyExistValidate implements ConstraintValidator<AlreadyExist, Integer> {
    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        HackerService hackerService = new HackerService();
        return hackerService.getHackers().stream().noneMatch(i -> Objects.equals(i.getId(), id));
    }
}
