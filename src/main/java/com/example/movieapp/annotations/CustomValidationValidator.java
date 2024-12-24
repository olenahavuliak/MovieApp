package com.example.movieapp.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidationValidator implements ConstraintValidator<CustomValidation, Object> {
    private int max;
    private int min;
    private String message;

    public CustomValidationValidator() {
    }

    public void initialize(CustomValidation customValidation) {
        this.max = customValidation.max();
        this.min = customValidation.min();
        this.message = customValidation.message();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        } else if (value instanceof String) {
            String stringValue = (String)value;
            if (stringValue.isEmpty()) {
                return true;
            } else {
                int length = stringValue.length();
                return this.isValidString(stringValue, length, context);
            }
        } else if (value instanceof Number) {
            Number numberValue = (Number)value;
            return this.isValidNumber(numberValue, context);
        } else {
            return true;
        }
    }

    private boolean isValidString(String value, int length, ConstraintValidatorContext context) {
        if (length < this.min) {
            this.buildConstraintViolation(String.format("Value should be at least %d symbols long", this.min), context);
            return false;
        } else if (length > this.max) {
            this.buildConstraintViolation(String.format("Value should be no more than %d symbols long", this.max), context);
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidNumber(Number number, ConstraintValidatorContext context) {
        double numericValue = number.doubleValue();
        if (numericValue < (double)this.min) {
            this.buildConstraintViolation(String.format("Value should be greater than %d", this.min), context);
            return false;
        } else if (numericValue > (double)this.max) {
            this.buildConstraintViolation(String.format("Value should be less than %d", this.max), context);
            return false;
        } else {
            return true;
        }
    }

    private void buildConstraintViolation(String message, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
