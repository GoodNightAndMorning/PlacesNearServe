package com.zsx.pn.anotationa;

import com.zsx.pn.utils.Utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneClass implements ConstraintValidator<Phone, Object> {

    private String values;

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        if (o != null && Utils.isMobileNO((String)o)) {
            return true;
        }
        return false;
    }

    @Override
    public void initialize(Phone constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }
}