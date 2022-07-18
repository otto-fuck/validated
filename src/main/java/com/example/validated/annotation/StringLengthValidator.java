package com.example.validated.annotation;

import com.example.validated.annotation.dict.FieldLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringLengthValidator implements ConstraintValidator<FieldLength, String> {
    private String type=null;
    @Override
    public void initialize(FieldLength constraintAnnotation) {
        type=  constraintAnnotation.type();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println(type);
        /**
         * 验证varchar的取值范围
         */
        if(type.equals("varchar")){
            if(value.length()>255){
                return false;
            }else {
                return true;
            }
        }
        /**
         * 验证char的取值范围
         */
        if(type.equals("char")){
            if(value.length()>255){
                return false;
            }else {
                return true;
            }
        }
        /**
         * 验证text的取值范围
         */
        if(type.equals("text")){
            if(value.length()>10){
                return false;
            }else {
                return true;
            }
        }



        return true;
    }
}
