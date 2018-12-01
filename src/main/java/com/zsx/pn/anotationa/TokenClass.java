package com.zsx.pn.anotationa;

import com.zsx.pn.service.RedisService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenClass implements ConstraintValidator<Token, Object>  {

    @Autowired
    private RedisService redisService;

    private String values;

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        if (o == null) {
            return false;
        }

        String token = (String)o;

        String[] strs = token.split("_");

        if (strs.length < 1) {
            return false;
        }

        String userId = strs[0];
        String severToken = (String)redisService.get("User_" + userId);
        if (token.equals(severToken)){
            return true;
        }

        return false;
    }

    @Override
    public void initialize(Token constraintAnnotation) {
        values = constraintAnnotation.values();
    }
}
