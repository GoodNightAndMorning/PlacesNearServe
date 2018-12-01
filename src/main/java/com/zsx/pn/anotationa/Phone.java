package com.zsx.pn.anotationa;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = PhoneClass.class)
public @interface Phone {
    String values();
    String message() default "请输入正确手机号码";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}



