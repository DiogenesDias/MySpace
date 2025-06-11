package com.dio.master.app.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ImdbIDValidator implements ConstraintValidator<CheckImdbID, String> {

    @Override
    public void initialize(CheckImdbID constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String imdbID, ConstraintValidatorContext cvContext) {
        if (imdbID == null) {
            return false;
        }
        return imdbID.matches("^tt\\d{7}$");
    }
}
