package com.br.Pokando.dto.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OptionalNotBlankValidator.class)
public @interface OptionalNotBlank {
    String message() default "O campo não pode estar vazio.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
