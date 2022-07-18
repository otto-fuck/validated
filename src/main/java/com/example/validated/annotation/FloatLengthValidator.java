package com.example.validated.annotation;

import com.example.validated.annotation.dict.FieldLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class FloatLengthValidator implements ConstraintValidator<FieldLength,Float> {
    private String type=null;

    @Override
    public void initialize(FieldLength constraintAnnotation) {
        type=constraintAnnotation.type();
    }

    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {
        return     sizeIsTrue(value);
    }


    private Boolean sizeIsTrue(Float s) {
        /**
         * 验证real和float4的取值范围
         */
        if (type.equals("float4")){
            if(s>1E+37){
                return false;
            }else if (s<1E-37){
                return false;
            }else {
                return true;
            }
        }else if(type.equals("real")){
            if(s>1E+37){
                return false;
            }else if (s<1E-37){
                return false;
            }else {
                return true;
            }
        }
        return true;
    }
}