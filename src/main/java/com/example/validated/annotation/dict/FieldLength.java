package com.example.validated.annotation.dict;


import com.example.validated.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 数据库字段长度校验
 */
@Constraint(validatedBy = {StringLengthValidator.class, IntLengthValidator.class, LongLengthValidator.class,
        FloatLengthValidator.class, DoubleLengthValidator.class})
@Documented
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldLength {

    String type() default "String";
    String message() default "String的值不能超过255";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
