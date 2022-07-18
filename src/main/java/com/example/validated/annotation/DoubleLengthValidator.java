package com.example.validated.annotation;

import com.example.validated.annotation.dict.FieldLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DoubleLengthValidator implements ConstraintValidator<FieldLength,Double> {
    private String type=null;

    @Override
    public void initialize(FieldLength constraintAnnotation) {
        type=  constraintAnnotation.type();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return     sizeIsTrue(value);
    }


    private Boolean sizeIsTrue(Double s) {
        /**
         * 验证precision和float8的取值范围
         */
        if (type.equals("float8")){
            System.out.println(s);
            if(s>1E+308){
                return false;
            }else if (s<1E-307){
                return false;
            }else {
                return true;
            }
        }else  if(type.equals("precision")){
            System.out.println(s);
            if(s>1E+308){
                return false;
            }else if (s<1E-307){
                return false;
            }else {
                return true;
            }
        }
        /**
         * 验证money的取值范围
         */
        if(type.equals("money")){
            System.out.println(s);
            if(s>92233720368547758.07){
                return false;
            }else if (s<-92233720368547758.08){
                return false;
            }else {
                return true;
            }
        }
        return true;
    }
}