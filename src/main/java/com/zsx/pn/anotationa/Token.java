package com.zsx.pn.anotationa;

import com.zsx.pn.utils.Constant;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = TokenClass.class)
public @interface Token {
    String values() default "验证token";
    String message() default Constant.TOKEN_UNVALID_STR;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}