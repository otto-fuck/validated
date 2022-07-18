package com.example.validated.annotation;



import com.example.validated.annotation.dict.FieldLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntLengthValidator implements ConstraintValidator<FieldLength,Integer> {
    private String type=null;

    @Override
    public void initialize(FieldLength constraintAnnotation) {
        type=  constraintAnnotation.type();

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return     sizeIsTrue(value);
    }

    /**
     * 验证不能超过Int的取值范围
     *
     * @param s
     * @return
     */
    private Boolean sizeIsTrue(Integer s) {
        /**
         * int2的范围
         */
        if (type.equals("int2")) {
            if (s > 32768) {
                return false;
            } else if (s < -32768) {
                return false;
            } else {
                return true;
            }
        }
        /**
         * int4的范围
         */
        if (type.equals("int4")) {
            if (s > 2147483647) {
                return false;
            } else if (s < -2147483647) {
                return false;
            } else {
                return true;
            }
        }
        /**
         * serial2的范围
         */
        if (type.equals("serial2")) {
            if (s > 32767) {
                return false;
            } else {
                return true;
            }
        }
        /**
         * serial4的范围
         */
        if (type.equals("serial4")) {
            if (s > 2147483647) {
                return false;
            } else {
                return true;
            }
        }
        /**
         * serial8的范围
         */
        if (type.equals("serial8")) {
            if (s > 9.223372036854775807*1000000000*1000000000) {
                return false;
            } else {
                return true;
            }
        }

        return true;

    }
}