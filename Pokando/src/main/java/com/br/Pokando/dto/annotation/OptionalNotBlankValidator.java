package com.br.Pokando.dto.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OptionalNotBlankValidator implements ConstraintValidator<OptionalNotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        return !value.trim().isEmpty();
    }
}
