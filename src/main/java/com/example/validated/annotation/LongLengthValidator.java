package com.example.validated.annotation;

import com.example.validated.annotation.dict.FieldLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class LongLengthValidator implements ConstraintValidator<FieldLength,Long> {
    private String type=null;

    @Override
    public void initialize(FieldLength constraintAnnotation) {
        type=  constraintAnnotation.type();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return     sizeIsTrue(value);
    }


    private Boolean sizeIsTrue(Long s) {
        /**
         * 验证int8的取值范围
         */
       if (type.equals("int8")){
               if( s>9.223372036854775807*1000000000*1000000000){
                   return false;
               }else if (s<-9.223372036854775807*1000000000*1000000000){
                   return false;
               }else {
                   return true;
               }
       }
       return true;
    }
}