package com.dio.master.app.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImdbIDValidator.class)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
public @interface CheckImdbID {
    String message() default "O imdbID é inválido. Deve seguir o formato 'tt1234567'.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}