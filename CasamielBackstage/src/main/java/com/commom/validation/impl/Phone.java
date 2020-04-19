package com.commom.validation.impl;

import com.commom.validation.PhoneAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Phone implements ConstraintValidator<PhoneAnnotation,String> {

    @Override
    public void initialize(PhoneAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
